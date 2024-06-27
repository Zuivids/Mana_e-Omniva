package com.example.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
	
	@Column(name = "ExperienceInYears")
	@Min(1)
	private float experienceInYears;
	
	@Column(name = "LicenseNo")
	@NotNull
	@Size(min = 8, max = 8)
	@Pattern(regexp = "[A]{1}[T]{1}[0-9]{6}", message = "Invalid license no")
	private String licenseNo;
	
	@OneToMany(mappedBy = "driver")
	@ToString.Exclude
	private Collection<Parcel> parcels;
	
	public Driver(String name , String surname, String personCode, float experienceInYears, String licenseNo ) {
		super(name, personCode, surname);
		setExperienceInYears(experienceInYears);
		setLicenseNo(licenseNo);
		
	}
	
	
	
}
