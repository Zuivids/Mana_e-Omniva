package com.example.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.AbstractCustomer;
import com.example.model.City;
import com.example.model.CustomerAsCompany;
import com.example.model.CustomerAsPerson;
import com.example.model.Parcel;
import com.example.repo.IAbstractCustomerRepo;
import com.example.repo.ICustomerAsCompanyRepo;
import com.example.repo.ICustomerAsPersonRepo;
import com.example.repo.IDriverRepo;
import com.example.repo.IParcelRepo;
import com.example.service.IParcelService;

@Service
public class ParcelServiceImpl implements IParcelService {

	@Autowired
	private IParcelRepo parcelRepo;
	@Autowired
	private IAbstractCustomerRepo abstractCustRepo;
	@Autowired
	private IDriverRepo driverRepo;
	@Autowired
	private ICustomerAsCompanyRepo customerAsCompanyRepo;

	@Autowired
	private ICustomerAsPersonRepo customerAsPersonRepo;

	@Override
	public ArrayList<Parcel> selectAllParcelsByCustomerId(int id) throws Exception {
		if (id < 0)
			throw new Exception("ID cant be negative");

		if (!abstractCustRepo.existsById(id))
			throw new Exception("Customer with " + id + " doesn't exist");
		ArrayList<Parcel> result = parcelRepo.findByAbstractCustomerIdc(id);

		if (result.isEmpty())
			throw new Exception("There is no parcel with " + id + " ID as customer");

		return result;
	}

	@Override
	public ArrayList<Parcel> selectAllParcelsDeliveredByDriverId(int id) throws Exception {
		if (id < 0)
			throw new Exception("ID cant be negative");
		ArrayList<Parcel> result = parcelRepo.findByDriverIdp(id);
		if (result.isEmpty())
			throw new Exception("There is no parcel with this id: " + id);
		return result;
	}

	@Override
	public ArrayList<Parcel> selectAllParcelsPriceLessThan(float price) throws Exception {
		if (price < 0.0)
			throw new Exception("Inccorect price value");
		ArrayList<Parcel> result = parcelRepo.findByPriceLessThan(price);
		if (result.isEmpty())
			throw new Exception("There is no parcel with price less than " + price + "$");
		return result;
	}

	@Override
	public ArrayList<Parcel> selectAllParcelsDeliveredToCity(City city) throws Exception {
		ArrayList<Parcel> result = parcelRepo.findByAbstractCustomerAddressCity(city);
		if (result.isEmpty())
			throw new Exception("No parcel(s) to city " + city);
		return result;
	}

	@Override
	public void insertNewParcelByCustomerCodeAndDriverId(String customer_code, int id, Parcel parcel) throws Exception {
		if (customerAsCompanyRepo.findByCustomerCode(customer_code) == null
				&& customerAsPersonRepo.findByCustomerCode(customer_code) == null)
			throw new Exception("Customer with " + customer_code + "ID does not exists!");
		if (driverRepo.findById(id) == null)
			throw new Exception("Driver with " + id + " ID does not exists!");
		Parcel newParcel = parcel;
		//TODO

	}

	@Override
	public void changeParcelDriverByParcelIdAndDriverId(int idpa, int idp) throws Exception {
		if (idpa < 0)
			throw new Exception("Inccorect Parcel ID");
		Parcel changeParcel = parcelRepo.findById(idpa).get();
		if (changeParcel.equals(null))
			throw new Exception("Invalid Parcel ID");
		if (idp < 0)
			throw new Exception("Incorrect Driver ID");
		if (driverRepo.findById(idp).equals(null))
			throw new Exception("Invalid Driver ID");
		changeParcel.setDriver(driverRepo.findById(idp));
		parcelRepo.save(changeParcel);

	}

	@Override
	public float calculateIncomeOfParcelsByCustomerId(int id) throws Exception {
		if (id < 0)
			throw new Exception("ID cant be negative");
		if (!abstractCustRepo.existsById(id))
			throw new Exception("Customer with " + id + " doesn't exists");
		float result = parcelRepo.calculateIncomeCustomerById(id);
		if (result == 0)
			throw new Exception("There is no parcels!");
		return result;
	}

	@Override
	public int calculateHowManyParcelsNeedToDeliverToday() throws Exception {
		int todayYear = LocalDateTime.now().getYear();
		int todayMonth = LocalDateTime.now().getMonthValue();
		int todayDay = LocalDateTime.now().getDayOfMonth();
		String combinedDate = "'" + todayYear + "-" + todayMonth + "-" + todayDay + "'%";
		int result = parcelRepo.countOfDeliveryForToday(combinedDate);
		return result;
	}

}
