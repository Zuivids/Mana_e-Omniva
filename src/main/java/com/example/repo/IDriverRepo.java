package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Driver;

public interface IDriverRepo extends CrudRepository<Driver , Integer> {

}
