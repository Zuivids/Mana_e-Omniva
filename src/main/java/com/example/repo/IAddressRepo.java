package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Address;

public interface IAddressRepo extends CrudRepository<Address, Integer> {

}
