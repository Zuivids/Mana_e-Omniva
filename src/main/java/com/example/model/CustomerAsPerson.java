package com.example.model;

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
public class CustomerAsPerson extends AbstractCustomer {

	@OneToOne
	@JoinColumn(name = "Idp")
	private Person person;

	public CustomerAsPerson(Person person, String phoneNo, Address address) {
		super(phoneNo, address);
		setPerson(person);
		setCustomerCode("0_person_"+person.getPersonCode());

	}
}
