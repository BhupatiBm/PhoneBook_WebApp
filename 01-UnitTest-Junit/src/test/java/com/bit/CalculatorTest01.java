package com.bit;
import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest01 {
	
	private static Calculator calc=null;
	@BeforeClass
	public static void init() {
		calc=new Calculator();
	} 
	
	@Test(timeout = 40)
	public void AddTest01() {
		new Calculator();
		int res=calc.add(10,5);
		int exp=15;
		assertEquals(exp,res);
	}
	@Test
	public void DivTest01() {
		
		int res=calc.div(100,5);
		int exp=20;
		assertEquals(exp,res);
	}
	@Test(expected = AssertionError.class)
	public void DivTest02() {
		
		int res=calc.div(-100,5);
		int exp=20;
		assertEquals(exp,res);
	}
	@Test
	public void MulTest01() {
		int res=calc.mul((int)2454564445454l,(int)5545444646l);
		//int exp=10;
		//assertEquals(exp,res);
	}
	@AfterClass
	public static void destroy() {
		calc=null;
	}
}
