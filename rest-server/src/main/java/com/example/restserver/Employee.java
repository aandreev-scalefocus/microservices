package com.example.restserver;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

//import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Document
@NoArgsConstructor @Data
public class Employee {

	//	id MUST be String for MongoDB; @GeneratedValue comes from JPA => remove it for MongoDB
	@Setter(AccessLevel.PROTECTED)
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;		
		
	private String name;

	public Employee(String name) {
		super();
		this.name = name;
	}	
}
