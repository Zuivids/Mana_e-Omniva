package com.example.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Driver;
import com.example.repo.IDriverRepo;
import com.example.service.IDriverCRUDService;

@Service
public class DriverServiceImpl implements IDriverCRUDService {

	@Autowired
	private IDriverRepo driverRepo;

	@Override
	public ArrayList<Driver> selectAllDriver() throws Exception {
		if (driverRepo.count() == 0)
			throw new Exception("Database is empty");

		return (ArrayList<Driver>) driverRepo.findAll();
	}

	@Override
	public Driver selectDriverById(int id) throws Exception {
		if (id < 0)
			throw new Exception("ID cant be negative ");

		if (driverRepo.existsById(id)) {
			return driverRepo.findById(id);
		} else {
			throw new Exception("Driver with " + id + ".ID is not found");
		}
	}

	@Override
	public void deleteDriverById(int id) throws Exception {
		if (id < 0)
			throw new Exception("ID cant be negative ");

		Driver deleteDriver = selectDriverById(id);

		driverRepo.delete(deleteDriver);

	}

	@Override
	public void insertNewDriver(Driver driver) throws Exception {
		Driver checkIfNotCreatedDriver = driverRepo.findByPersonCode(driver.getPersonCode());

		if (checkIfNotCreatedDriver != null)
			throw new Exception("Driver with person code: " + driver.getPersonCode() + " is existing in DB!");

		driverRepo.save(driver);

	}

	@Override
	public void updateDriverById(int id, Driver driver) throws Exception {
		if (id < 0)
			throw new Exception("ID cant be negative ");
		if (!driverRepo.existsById(id))
			throw new Exception("Driver is not exisitng in DB!");
		Driver driverForUpdating = selectDriverById(id);
		driverForUpdating.setName(driver.getName());
		driverForUpdating.setSurname(driver.getSurname());
		driverForUpdating.setPersonCode(driver.getPersonCode());
		driverForUpdating.setExperienceInYears(driver.getExperienceInYears());
		driverForUpdating.setLicenseNo(driver.getLicenseNo());

		driverRepo.save(driverForUpdating);

	}

}
