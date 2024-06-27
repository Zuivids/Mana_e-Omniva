package com.example.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.AbstractCustomer;
import com.example.model.Address;
import com.example.model.CustomerAsCompany;
import com.example.model.CustomerAsPerson;
import com.example.repo.IAbstractCustomerRepo;
import com.example.repo.ICustomerAsCompanyRepo;
import com.example.repo.ICustomerAsPersonRepo;
import com.example.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerAsPersonRepo customerAsPersonRepo;

	@Autowired
	private ICustomerAsCompanyRepo customerAsCompanyRepo;

	@Autowired
	private IAbstractCustomerRepo abstractCustomerRepo;

	@Override
	public void insertNewCustomerAsPerson(CustomerAsPerson customerAsPerson) throws Exception {
		if (customerAsPerson == null)
			throw new Exception("Customer is not existing in DB!");
		if (customerAsPersonRepo.findByPersonPersonCode(customerAsPerson.getPerson().getPersonCode()) != null)
			throw new Exception("CustomerAsPerson is already existing!");
		customerAsPersonRepo.save(customerAsPerson);

	}

	@Override
	public void insertNewCustomerAsCompany(CustomerAsCompany customerAsCompany) throws Exception {
		if (customerAsCompany == null)
			throw new Exception("Customer is not existing in DB!");
		if (customerAsCompanyRepo.findByCompanyRegNo(customerAsCompany.getCompanyRegNo()) != null)
			throw new Exception("CustomerAsPerson is already existing!");
		customerAsCompanyRepo.save(customerAsCompany);

	}

	@Override
	public void addAddressToCustomerByCustomerId(int id, Address address) throws Exception {
		if (id < 0)
			throw new Exception("ID cant be negative !");
		if (address == null)
			throw new Exception("Address is not existing in DB!");
		AbstractCustomer abstractCustomer = abstractCustomerRepo.findById(id).get();
		abstractCustomer.setAddress(address);
		abstractCustomerRepo.save(abstractCustomer);

	}

	@Override
	public ArrayList<AbstractCustomer> selectAllCustomers() throws Exception {
		if (abstractCustomerRepo.count() == 0)
			throw new Exception("Database is empty");

		return (ArrayList<AbstractCustomer>) abstractCustomerRepo.findAll();
	}

}
