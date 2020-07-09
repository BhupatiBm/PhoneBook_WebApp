package com.bit.service;

import java.util.List;

import com.bit.model.Employee;

public interface EmployeeService {
	
	public String GetNameById(Integer id) ;
	
	public List<String> GetAllName();
	
	public Employee getEmpById(Integer id);

}
