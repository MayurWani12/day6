package com.example.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.Employeeservice;
import com.example.entity.Employee;
@RestController
@RequestMapping("/employee")
public class Employeecontroller {
	
	@Autowired
	private Employeeservice employeeservice;
	
	@GetMapping
	public List<Employee>getAllEmployees(){
		return employeeservice.getallEmployees();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){
		Optional<Employee> employee = employeeservice.getEmployeeById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	
	
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		
		return employeeservice.saveEmployee(employee);
	}
	
	
	 @PutMapping("/{id}")
	    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employeedetails) {
	        return ResponseEntity.ok(employeeservice.updateEmployee(id, employeedetails));
	    }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteEmployee(Integer id){
		 
		 employeeservice.deleteEmployee(id);
		return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	

}
