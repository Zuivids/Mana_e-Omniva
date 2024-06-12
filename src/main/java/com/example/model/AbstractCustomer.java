package com.example.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
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
@Table(name = "AbstractCustomerTable")
@Entity

public class AbstractCustomer {
	
	@Id
	@Column(name = "Idc")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idc;
	
	
	@Column(name = "PhoneNo")
	@Size(min = 8, max = 8)
	@Pattern(regexp = "[0-9]{8}", message = "Only numbers are allowed with out country code before")
	private String phoneNo;
	
	//TODO ????
	private String customerCode;

	@ManyToOne
	@JoinColumn(name="Ida")
	private Address address;
	
	@OneToMany(mappedBy = "abstractCustomer")
	@ToString.Exclude
	private Collection<Parcel> parcel;

	public AbstractCustomer(String phoneNo, Address address) {
		setPhoneNo(phoneNo);
		setAddress(address);
	}
	
	
}
