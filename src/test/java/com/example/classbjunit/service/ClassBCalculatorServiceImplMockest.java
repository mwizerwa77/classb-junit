package com.example.classbjunit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ClassBCalculatorServiceImplMockest {

	@InjectMocks
	ClassBCalculatorServiceImpl calcServiceImpl;

	@Mock
	private CalculatorService calculatorServiceMock;

	@Test
	public void calcSum_manyElement() {

		when(calculatorServiceMock.getAll()).thenReturn(new int[] { 1, 2, 4 });
		assertEquals(7, calcServiceImpl.calcSumForServiceData());
	}

	@Test
	public void calcSum_emptyList() {

		when(calculatorServiceMock.getAll()).thenReturn(new int[] {});

		assertEquals(0, calcServiceImpl.calcSumForServiceData());
	}

	@Test
	public void calcSum_oneElement() {

		when(calculatorServiceMock.getAll()).thenReturn(new int[] { 4 });
		assertEquals(4, calcServiceImpl.calcSumForServiceData());
	}
}
