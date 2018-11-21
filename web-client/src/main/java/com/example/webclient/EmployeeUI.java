package com.example.webclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.crudui.layout.impl.VerticalCrudLayout;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SuppressWarnings("serial")
@SpringUI(path = "/")
public class EmployeeUI extends UI {

	@Autowired
	private EmployeeService employeeService;

	@Override
	protected void init(VaadinRequest request) {
		Label title = new Label("Employees");
		title.addStyleName(ValoTheme.LABEL_H2);

		GridCrud<Employee> crudGrid = new GridCrud<>(Employee.class, new VerticalCrudLayout());
		crudGrid.getGrid().setColumns("id", "name");
		crudGrid.getCrudFormFactory().setVisibleProperties("name");
		crudGrid.getCrudFormFactory().setUseBeanValidation(true);
		crudGrid.setClickRowToUpdate(true);
		crudGrid.setUpdateOperationVisible(false);

		crudGrid.setFindAllOperation(() -> employeeService.findAll().getContent());
		crudGrid.setAddOperation(employee -> employeeService.add(employee).getContent());
		crudGrid.setUpdateOperation(employee -> employeeService.update(employee.getId(), employee).getContent());
		crudGrid.setDeleteOperation(employee -> employeeService.delete(employee.getId()));

		VerticalLayout layout = new VerticalLayout(title, crudGrid);
		layout.setHeightUndefined();
		layout.setMargin(false);

		setContent(layout);
	}

}