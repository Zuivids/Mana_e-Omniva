package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.model.AbstractCustomer;
import com.example.model.CustomerAsCompany;

public interface IAbstractCustomerRepo extends CrudRepository<AbstractCustomer, Integer>{

	AbstractCustomer findByCustomerAsCompany(CustomerAsCompany customerAsCompany);

}
