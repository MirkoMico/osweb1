package com.example.OSWEB1.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OSWEB1.exception.ResourceNotFoundException;
import com.example.OSWEB1.model.Employee;
import com.example.OSWEB1.repository.EmployeeRepository;
import com.example.OSWEB1.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}



	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);	
	}



	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}



	@Override
	public Employee getEmployeeById(long id) {
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		} else {
//			
//			throw new ResourceNotFoundException("Employee","id",id);
//		}
		return employeeRepository.findById(id).orElseThrow(()-> new 
				ResourceNotFoundException("Employee", "id", id));	
	}



	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee existingEmployee = employeeRepository.findById(id)
				.orElseThrow( ()-> new ResourceNotFoundException("Employee","Id",id)) ;
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}



	@Override
	public void deleteEmployee(long id) {
		
		employeeRepository.findById(id).orElseThrow(
				()->(new ResourceNotFoundException("Employee", "Id", id)));
		employeeRepository.deleteById(id);
		
	}

}
