package com.example.webclient;

import java.util.Collections;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Component;

@Component
//@RequestMapping("endpoint-will-never-be-accessed")
public class EmployeeServiceFallback implements EmployeeService {

	@Override
	public Resources<Employee> findAll() {
		return new Resources<>(Collections.<Employee>emptyList());
	}

	@Override
	public Resource<Employee> add(Employee employee) {
		return new Resource<>(new Employee());
	}

	@Override
	public Resource<Employee> update(String id, Employee employee) {
		return new Resource<>(new Employee());
	}

	@Override
	public void delete(String id) {
	}

}
