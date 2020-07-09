package com.bit.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bit.dao.EmployeeDao;
import com.bit.excepption.NoDataFoundException;
import com.bit.model.Employee;
import com.bit.service.EmployeeServiceImpl;

public class EmployeeServiceTest {

	private static EmployeeServiceImpl empser;

	@BeforeClass
	public static void init() {
		empser=new EmployeeServiceImpl();
		Employee emp1=new Employee();
		//create proxy
		EmployeeDao proxydao=EasyMock.createMock(EmployeeDao.class);
		//setting behaviour for dao method
		EasyMock.expect(proxydao.FindNameById(100)).andReturn("bhupati");

		List<String> names=new ArrayList();
		names.add("bhupati");names.add("ramu");
		names.add("hari");names.add("Shyam");
		EasyMock.expect(proxydao.FindAllNames()).andReturn(names);

		emp1.setId(101);
		emp1.setName("Raghu");
		emp1.setNumber(8531649275l);
		EasyMock.expect(proxydao.FindEmpById(101)).andReturn(emp1);
		EasyMock.expect(proxydao.FindEmpById(205)).andReturn(null);

		EasyMock.replay(proxydao);
		empser.setEmpDao(proxydao);

	}


	@Test
	public void GetEmpNameByIdTest01() {
		String name=empser.GetNameById(100);
		assertNotNull(name);
	}

	@Test
	public void GetAllEmpNameTest() {
		List<String> allName=empser.GetAllName();
		assertNotNull(allName);
	}

	@Test
	public void getEmpByIdTest01() {
		Employee emp=empser.getEmpById(101);
		assertNotNull(emp);
	}

	@Test(expected = NoDataFoundException.class)
	public void getEmpByIdTest02() {
		Employee emp=empser.getEmpById(205);	
	}


	@AfterClass
	public static void destroy() {
		empser=null;
	}

}
