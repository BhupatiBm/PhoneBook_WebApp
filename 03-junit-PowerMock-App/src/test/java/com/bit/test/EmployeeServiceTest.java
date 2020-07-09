package com.bit.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

import com.bit.dao.EmployeeDao;
import com.bit.excepption.NoDataFoundException;
import com.bit.service.EmployeeServiceImpl;

public class EmployeeServiceTest {

	@Test
	public void GetEmpNameByIdTest01() {
		EmployeeServiceImpl empser=new EmployeeServiceImpl();
		EmployeeDao mockDao=mock(EmployeeDao.class);
		when(mockDao.FindNameById(100)).thenReturn("Bhupati");
		empser.setEmpDao(mockDao);
		String name=empser.GetNameById(100);
		assertNotNull(name);
	}
	
	@Test(expected = NoDataFoundException.class)
	public void GetAllEmpNameTest() {
		EmployeeServiceImpl empser=new EmployeeServiceImpl();
		EmployeeDao mockDao=mock(EmployeeDao.class);
		when(mockDao.FindAllNames()).thenReturn(null);
		empser.setEmpDao(mockDao);
		List<String> allName=empser.GetAllName();
		
	}
//
//	@Ignore
//	@Test
//	public void getEmpByIdTest01() {
//		Employee emp=empser.getEmpById(101);
//		assertNotNull(emp);
//	}
//
//	@Test(expected = NoDataFoundException.class)
//	@Ignore
//	public void getEmpByIdTest02() {
//		Employee emp=empser.getEmpById(205);	
//	}
//
//
//	@AfterClass
//	@Ignore
//	public static void destroy() {
//		empser=null;
//	}
//
}
