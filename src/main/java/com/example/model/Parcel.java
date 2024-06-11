package com.example.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Parcel {

	private int idpa;
	private boolean isFragile;
	private LocalDateTime orderCreated;
	private LocalDateTime planedDelivery;
	private float price;
	private float size;
	private Driver driver;
	private AbstractCustomer customer;

	// TODO
	// IDC
	// IDP

	public Parcel(boolean isFragile, LocalDateTime orderCreated, LocalDateTime planedDelivery, float price,
			float size) {
		// setIsFragile();

	}
}
