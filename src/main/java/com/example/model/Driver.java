package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "DriverTable")
@Entity
public class Driver extends Person {
	
	@Column(name = "Experience_in_years")
	@Min(1)
	private float experienceInYears;
	
	@Column(name = "License_no")
	@NotNull
	@Size(min = 8, max = 8)
	@Pattern(regexp = "[A]{1}[T]{1}[0-9]{6}", message = "Invalid license no")
	private String licenseNo;
	
	//TODO izveidot saiti uz Parcel
	
	public Driver(String name , String surname, String personCode, float experienceInYears, String licenseNo ) {

		setName(surname);
		setSurname(surname);
		setPersonCode(personCode);
		setExperienceInYears(experienceInYears);
		setLicenseNo(licenseNo);
		
	}
	
	
	
}
