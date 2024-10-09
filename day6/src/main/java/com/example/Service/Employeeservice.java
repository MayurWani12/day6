package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
@Service
public class Employeeservice {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public List<Employee>getallEmployees(){
		
		return employeeRepository.findAll();
	}
	
	public Optional<Employee> getEmployeeById(Integer id){
		
		return employeeRepository.findById(id);
		
	}
	
	
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
		
	}
	
	
	public void deleteEmployee(Integer id) {
		
		 employeeRepository.deleteById(id);
	}
	
	
	public Employee updateEmployee(Integer id,Employee employeedetails) {
		
		
		Employee employee=employeeRepository.findById(id).orElseThrow();
		
		employee.setName(employeedetails.getName());
		employee.setEmail(employeedetails.getEmail());
		employee.setDepartment(employeedetails.getDepartment());
		return employeeRepository.save(employee);
		
	}

}
