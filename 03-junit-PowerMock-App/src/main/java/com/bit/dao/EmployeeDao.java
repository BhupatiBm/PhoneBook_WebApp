package com.bit.dao;

import java.util.List;

import com.bit.model.Employee;

public interface EmployeeDao {
	
	public String FindNameById(Integer id);
	
	public List<String> FindAllNames();
	
	public Employee FindEmpById(Integer id);

}
