package com.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AbstractCustomer {
	
	private int idc;
	private Address adress;
	private String customerCode;
	private String phoneNo;
	
}
