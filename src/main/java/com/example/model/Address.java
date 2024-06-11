package com.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Address {
	
	private int ida;
	private City city;
	private int houseNo;
	private String streetOrHouseTitle;
}
