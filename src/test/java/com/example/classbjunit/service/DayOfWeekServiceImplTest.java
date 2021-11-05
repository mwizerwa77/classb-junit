package com.example.classbjunit.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DayOfWeekServiceImplTest {

	@Test
	public void test_pass() {
		DayOfWeekServiceImpl dayofweek = new DayOfWeekServiceImpl();
		String result = dayofweek.getDay(1);
		String expected = "MONDAY";
		assertEquals(result,expected);
	}
	@Test
	public void getDay_invalidTest() {
		DayOfWeekServiceImpl dayofweek = new DayOfWeekServiceImpl();
		String result = dayofweek.getDay(8);
		String expected = "Invalid";
		assertEquals(result,expected);
	}
	

}
