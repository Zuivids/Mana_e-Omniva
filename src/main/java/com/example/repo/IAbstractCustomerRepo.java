package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.model.AbstractCustomer;

public interface IAbstractCustomerRepo extends CrudRepository<AbstractCustomer, Integer>{

}
