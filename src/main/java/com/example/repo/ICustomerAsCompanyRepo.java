package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.model.CustomerAsCompany;

public interface ICustomerAsCompanyRepo extends CrudRepository<CustomerAsCompany, Integer> {

}
