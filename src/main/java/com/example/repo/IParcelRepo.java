package com.example.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.model.City;
import com.example.model.Parcel;

public interface IParcelRepo extends CrudRepository<Parcel, Integer> {

	ArrayList<Parcel> findByAbstractCustomerIdc(int id);

	ArrayList<Parcel> findByDriverIdp(int id);

	ArrayList<Parcel> findByPriceLessThan(float price);

	ArrayList<Parcel> findByAbstractCustomerAddressCity(City city);

	@Query(nativeQuery = true, value = "SELECT sum(price) FROM parcel WHERE idc=(?1);")
	float calculateIncomeCustomerById(int id);

	@Query(nativeQuery = true, value = "SELECT count(idpa) FROM parcel WHERE order_delivery LIKE (?1);")
	int countOfDeliveryForToday(String combinedDate);

}
