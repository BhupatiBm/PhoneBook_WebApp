package com.bit.service;

import java.util.List;

import com.bit.dao.EmployeeDao;
import com.bit.excepption.NoDataFoundException;
import com.bit.model.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	
	EmployeeDao empDao;

	public void setEmpDao(EmployeeDao empDao) {
		this.empDao = empDao;
	}

	public String GetNameById(Integer id) {
		String name=empDao.FindNameById(id);
		return name;
	}

	public List<String> GetAllName() {
		List<String> allName=empDao.FindAllNames();
		if(allName==null)
		{
			throw new NoDataFoundException("erroor");
		}
		return allName;
	}

	public Employee getEmpById(Integer id) {
		Employee details=empDao.FindEmpById(id);
		if(details==null) {
			throw new NoDataFoundException("wrong id");
		}
		return details;
	}
	

}
