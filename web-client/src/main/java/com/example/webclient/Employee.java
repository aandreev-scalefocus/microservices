package com.example.webclient;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@NoArgsConstructor @AllArgsConstructor @Data
public class Employee implements Serializable {

	@Id
	private String id;
	private String name;

	public Employee(String name) {
		super();
		this.name = name;
	}	

}
