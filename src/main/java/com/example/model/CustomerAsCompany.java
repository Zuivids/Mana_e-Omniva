package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Table(name = "CustomerAsCompanyTable")
@Entity
public class CustomerAsCompany extends AbstractCustomer{

	@Column(name = "Title")
	@NotNull
	@Size (min = 5, max = 30)
	@Setter
	private String title;
	
	@Column(name = "CompanyRegNo")
	@NotNull
	@Size(min = 13, max = 13)
	@Pattern(regexp = "[L]{1}[V]{1}[0-9]{11}", message = "Invalid registration number")
	@Setter
	private String companyRegNo;
	
	public CustomerAsCompany(String title, String companyRegNo) {
		setTitle(title);
		setCompanyRegNo(companyRegNo);
		
	}
	
}
