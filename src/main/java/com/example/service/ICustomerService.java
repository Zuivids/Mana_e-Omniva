package com.example.service;

import java.util.ArrayList;

import com.example.model.AbstractCustomer;
import com.example.model.Address;
import com.example.model.CustomerAsCompany;
import com.example.model.CustomerAsPerson;

public interface ICustomerService {

	public abstract void insertNewCustomerAsPerson(CustomerAsPerson customerAsPerson) throws Exception;

	public abstract void insertNewCustomerAsCompany(CustomerAsCompany customerAsCompany) throws Exception;

	public abstract void addAddressToCustomerByCustomerId(int id, Address address) throws Exception;

	public abstract ArrayList<AbstractCustomer> selectAllCustomers() throws Exception;
}
