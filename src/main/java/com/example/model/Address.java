package com.example.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "AddressTable")
@Entity
public class Address {
	
	@Id
	@Column(name = "Ida")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int ida;
	
	@NotNull
	@Column(name="City")
	private City city;
	
	@NotNull
	@Min(1)
	@Column(name = "HouseNo")
	private int houseNo;
	
	@Column(name = "Street_or_house_title")
	@NotNull
	@Size(min = 3, max = 30)
	private String streetOrHouseTitle;
	
	@OneToMany(mappedBy = "address")
	@ToString.Exclude
	private Collection<AbstractCustomer> abstarctCustomer;
	
	
	public Address(City city, int houseNo, String streetOrHouseTitle) {
		setCity(city);
		setHouseNo(houseNo);
		setStreetOrHouseTitle(streetOrHouseTitle);
	}
	
}
