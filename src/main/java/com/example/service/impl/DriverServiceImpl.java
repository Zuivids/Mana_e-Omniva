package com.example.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Driver;
import com.example.repo.IDriverRepo;
import com.example.service.IDriverCRUDService;

@Service
public class DriverServiceImpl implements IDriverCRUDService{

	@Autowired
	private IDriverRepo driverRepo;
	
	@Override
	public ArrayList<Driver> selectAllDriver() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Driver selectDriverById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDriverById(int Id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertNewDriver(Driver driver) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDriverById(int id, Driver driver) throws Exception {
		// TODO Auto-generated method stub
		
	}

}	
