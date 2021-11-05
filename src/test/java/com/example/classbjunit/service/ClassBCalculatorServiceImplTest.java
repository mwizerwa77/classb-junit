package com.example.classbjunit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class ClassBCalculatorServiceImplTest {

	@Test
	public void calcSum_manyElement() {
		ClassBCalculatorServiceImpl calcServiceImpl = new ClassBCalculatorServiceImpl();

		int actualResult = calcServiceImpl.calcSum(new int[] {1,2,-3});
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calcSum_emptyList() {
		ClassBCalculatorServiceImpl calcServiceImpl = new ClassBCalculatorServiceImpl();

		int actualResult = calcServiceImpl.calcSum(new int[] {});
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void calcSum_oneElement() {
		ClassBCalculatorServiceImpl calcServiceImpl = new ClassBCalculatorServiceImpl();

		int actualResult = calcServiceImpl.calcSum(new int[] {4});
		int expectedResult = 4;
		assertEquals(expectedResult, actualResult);
	}
}
