package com.example.restserver;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.ProfileResourceProcessor;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee, String> {
}

//@RepositoryRestResource
//public interface EmployeeRepository extends MongoRepository<Employee, String> {
//}

@Configuration
class EmployeeRepositoryConfig extends RepositoryRestMvcConfiguration {

	public EmployeeRepositoryConfig(ApplicationContext context, ObjectFactory<ConversionService> conversionService) {
		super(context, conversionService);
	}

	@Override
	public ProfileResourceProcessor profileResourceProcessor(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Employee.class);
		return super.profileResourceProcessor(config);
	}

}