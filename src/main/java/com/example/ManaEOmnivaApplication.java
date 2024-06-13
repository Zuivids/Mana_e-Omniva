package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.model.Address;
import com.example.model.City;
import com.example.model.Person;
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
				
				
				
			}
		};
	}
}
