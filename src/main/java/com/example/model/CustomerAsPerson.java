package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "CustomerAsPersonTable")
@Entity
public class CustomerAsPerson extends AbstractCustomer{

	@OneToOne
	@JoinColumn(name = "Idp")
	private Person person;

	@Column(name = "CustomerCode")
	@Setter
	private String customerCode;

	@Column(name = "PhoneNo")
	@Setter
	private String phoneNo;

	@Column(name = "Adress")
	@Setter
	private String adress;

	public CustomerAsPerson(String customerCode, String phoneNo, String adress) {

		setCustomerCode(customerCode);
		setPhoneNo(phoneNo);
		setAdress(adress);
	}
}
