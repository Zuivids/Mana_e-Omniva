package com.example;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.model.AbstractCustomer;
import com.example.model.Address;
import com.example.model.City;
import com.example.model.CustomerAsCompany;
import com.example.model.CustomerAsPerson;
import com.example.model.Driver;
import com.example.model.Parcel;
import com.example.model.Person;
import com.example.model.Size;
import com.example.repo.IAbstractCustomerRepo;
import com.example.repo.IAddressRepo;
import com.example.repo.ICustomerAsCompanyRepo;
import com.example.repo.ICustomerAsPersonRepo;
import com.example.repo.IDriverRepo;
import com.example.repo.IParcelRepo;
import com.example.repo.IPersonRepo;

@SpringBootApplication
public class ManaEOmnivaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManaEOmnivaApplication.class, args);
	}

	@Bean
	public CommandLineRunner testForDB(IAbstractCustomerRepo absCusRepo, IAddressRepo adrRepo, ICustomerAsCompanyRepo cusCompRepo,
			ICustomerAsPersonRepo cusPerRepo, IDriverRepo driverRepo, IParcelRepo parcelRepo, IPersonRepo personRepo ) {
			
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {

				Address address1 = new Address(City.Riga,1,"Popes iela");
				Address address2 = new Address(City.Ventspils,2,"Cēsu iela");
				Address address3 = new Address(City.Liepaja,3,"Annas iela");
				adrRepo.save(address1);
				adrRepo.save(address2);
				adrRepo.save(address3);
				
				Person person1 = new Person("Valdis", "123456-54321", "Dombrovskis");
				Person person2 = new Person("Artis", "654321-12345", "Pabriks");
				Person person3 = new Person("Nils", "123654-12345", "Ušakovs");
				personRepo.save(person1);
				personRepo.save(person2);
				personRepo.save(person3);
				
				Driver driver1 = new Driver("Jānis","Ritentiņš", "121212-12345",(float)1.1,"AT123456");
				Driver driver2 = new Driver("Aldis","Gobzems","111111-42343",(float)2.1,"AT654321");
				Driver driver3 = new Driver("Valdis","Šosejnieks","101010-12412",(float)3.3,"AT123654");
				driverRepo.save(driver1);
				driverRepo.save(driver2);
				driverRepo.save(driver3);
				
				//For CustomerAsPerson
				AbstractCustomer aCustomer1 = new AbstractCustomer("21212121",address1 );
				AbstractCustomer aCustomer2 = new AbstractCustomer("22222222",address2 );
				AbstractCustomer aCustomer3 = new AbstractCustomer("23232323",address3 );
				absCusRepo.save(aCustomer1);
				absCusRepo.save(aCustomer2);
				absCusRepo.save(aCustomer3);
				//For CustomerAsCompany
				AbstractCustomer aCustomer4 = new AbstractCustomer("24242424",address1 );
				AbstractCustomer aCustomer5 = new AbstractCustomer("25252525",address2 );
				AbstractCustomer aCustomer6 = new AbstractCustomer("26262626",address3 );
				absCusRepo.save(aCustomer4);
				absCusRepo.save(aCustomer5);
				absCusRepo.save(aCustomer6);
				
				//TODO ADD customerCode
				//WORKING 50%
				CustomerAsPerson customerAsPerson1 = new CustomerAsPerson(person1,person1,aCustomer1.getPhoneNo(),aCustomer1.getAddress());
				CustomerAsPerson customerAsPerson2 = new CustomerAsPerson(person2,person2,aCustomer2.getPhoneNo(),aCustomer2.getAddress());
				CustomerAsPerson customerAsPerson3 = new CustomerAsPerson(person3,person3,aCustomer3.getPhoneNo(),aCustomer3.getAddress());
				cusPerRepo.save(customerAsPerson1);
				cusPerRepo.save(customerAsPerson2);
				cusPerRepo.save(customerAsPerson3);
				
				//TODO ADD customerCode
				//ADDRESS NOT WORKING
				CustomerAsCompany customerAsCompany1 = new CustomerAsCompany("SIA Firma", "LV12345678910",aCustomer4.getPhoneNo(), aCustomer4.getAddress());
				CustomerAsCompany customerAsCompany2 = new CustomerAsCompany("SIA Kompānija", "LV10987654321",aCustomer5.getPhoneNo(), aCustomer5.getAddress());
				CustomerAsCompany customerAsCompany3 = new CustomerAsCompany("SIA Uzņēmums", "LV12345109876",aCustomer6.getPhoneNo(), aCustomer6.getAddress());
				cusCompRepo.save(customerAsCompany1);
				cusCompRepo.save(customerAsCompany2);
				cusCompRepo.save(customerAsCompany3);	
				
				
				LocalDateTime orderCreated = null;
				LocalDateTime planedDelivery = null;
				
				Parcel parcel1 = new Parcel(false,Size.M,(float) 12.4,orderCreated.now(),planedDelivery.now(),aCustomer1,driver1);
				Parcel parcel2 = new Parcel(true,Size.XL,(float)100,orderCreated.now(),planedDelivery.now(),aCustomer2, driver2);
				Parcel parcel3 = new Parcel(false,Size.S,(float)5,orderCreated.now(),planedDelivery.now(),aCustomer3, driver3);
				parcelRepo.save(parcel1);
				parcelRepo.save(parcel2);
				parcelRepo.save(parcel3);
				
			}
		};
	}
}
