package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.model.CustomerAsPerson;

public interface ICustomerAsPersonRepo extends CrudRepository<CustomerAsPerson, Integer> {

	CustomerAsPerson findByCustomerCode(String customer_code);

	CustomerAsPerson findByPersonPersonCode(String person_code);

}
