package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Parcel;

public interface IParcelRepo extends CrudRepository<Parcel, Integer> {

}
