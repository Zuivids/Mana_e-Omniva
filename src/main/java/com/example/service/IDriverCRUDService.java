package com.example.service;

import java.util.ArrayList;

import com.example.model.Driver;

public interface IDriverCRUDService {

	public ArrayList<Driver> selectAllDriver() throws Exception;

	public Driver selectDriverById(int id) throws Exception;

	public void deleteDriverById(int id) throws Exception;

	public void insertNewDriver(Driver driver) throws Exception;

	public void updateDriverById(int id, Driver driver) throws Exception;

}
