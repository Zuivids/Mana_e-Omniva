package com.example.service.impl;

import java.util.ArrayList;

import com.example.model.City;
import com.example.model.Parcel;
import com.example.service.IParcelService;

public class ParcelServiceImpl implements IParcelService{

	@Override
	public ArrayList<Parcel> selectAllParcelsByCustomerId(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Parcel> selectAllParcelsDeliveredByDriverId(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Parcel> selectAllParcelsPriceLessThan(float price) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Parcel> selectAllParcelsDeliveredToCity(City city) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertNewParcelByCustomerCodeAndDriverId(String customer_code, int id, Parcel parcel) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeParcelDriverByParcelIdAndDriverId(int idp, int idd) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float calculateIncomeOfParcelsByCustomerId(int id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int calculateHowManyParcelsNeedToDeliverToday() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
