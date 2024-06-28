package com.example.service;

import java.util.ArrayList;

import com.example.model.City;
import com.example.model.Parcel;

public interface IParcelService {

	public ArrayList<Parcel> selectAllParcelsByCustomerId(int id) throws Exception;
	
	public ArrayList<Parcel> selectAllParcelsDeliveredByDriverId(int id) throws Exception;
	
	public ArrayList<Parcel> selectAllParcelsPriceLessThan(float price) throws Exception;
	
	public ArrayList<Parcel> selectAllParcelsDeliveredToCity(City city) throws Exception;
	
	public void insertNewParcelByCustomerCodeAndDriverId(String customer_code, int id, Parcel parcel) throws Exception;
	
	public void changeParcelDriverByParcelIdAndDriverId(int idp, int idd) throws Exception;
	 
	public float calculateIncomeOfParcelsByCustomerId(int id) throws Exception;
	
	public int calculateHowManyParcelsNeedToDeliverToday() throws Exception;
	
	public void removeParcelByDriver(int id) throws Exception;
}
