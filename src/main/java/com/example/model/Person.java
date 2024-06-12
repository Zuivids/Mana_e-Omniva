package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "PersonTable")
@Entity
public class Person {

	@Id
	@Column(name = "Idp")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idp;

	@Column(name = "Name")
	@NotNull
	@Size(min = 3, max = 50)
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅa-zēūīļķģšāžčņ ]+", message = "Only letters and space are allowed")
	private String name;

	@Column(name = "Surname")
	@NotNull
	@Size(min = 3, max = 50)
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+", message = "Only letters and space are allowed")
	private String surname;

	@Column(name = "PersonCode")
	@NotNull
	@Size(min = 12, max = 12)
	@Pattern(regexp = "[0-9]{6}-[0-9]{5}", message = "Only numbers and '-' are allowed")
	private String personCode;

	// TODO izveidot saiti uz CustomerAsPerson
	private CustomerAsPerson customerAsPerson;

	public Person(String name, String surname, String person_code) {
		setName(name);
		setSurname(surname);
		setPersonCode(person_code);
		
	}

}
