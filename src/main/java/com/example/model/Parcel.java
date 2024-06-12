package com.example.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "ParcelTable")
@Entity
public class Parcel {

	@Id
	@Column(name = "Idpa")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idpa;

	@Column(name = "IsFragile")
	@NotNull
	@Setter
	private boolean isFragile;

	@Column(name = "OrderCreated")
	@Setter
	private LocalDateTime orderCreated;

	@Column(name = "OrderDelivery")
	@Setter
	private LocalDateTime planedDelivery;

	@Column(name = "Price")
	@NotNull
	@Setter
	private float price;

	@Column(name = "Size")
	@NotNull
	private Size size;

	@ManyToOne
	@JoinColumn(name = "IDP")
	private Driver driver;

	@ManyToOne
	@JoinColumn(name = "IDC")
	private AbstractCustomer customer;


	public Parcel(boolean isFragile, Size size, float price, LocalDateTime orderCreated, LocalDateTime planedDelivery,
			AbstractCustomer customer, Driver driver) {
		setFragile(isFragile);
		setSize(size);
		setPrice(price);
		setOrderCreated(orderCreated);
		setPlanedDelivery(planedDelivery);
		setCustomer(customer);
		setDriver(driver);

	}

}
