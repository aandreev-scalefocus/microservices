package com.example.webclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${rest-server.name:null}", path = "/employees", fallback = EmployeeServiceFallback.class)
public interface EmployeeService {
	
	@GetMapping
	Resources<Employee> findAll();
	
	@PostMapping
	Resource<Employee> add(@RequestBody Employee employee);
	
	@PutMapping(value = "/{id}")
	Resource<Employee> update(@PathVariable("id") String id, @RequestBody Employee employee);

	@DeleteMapping(value = "/{id}")
	void delete(@PathVariable("id") String id);
}
