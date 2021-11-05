package com.example.classbjunit.service;

public class DayOfWeekServiceImpl {

	public String getDay(int num) {
		switch(num) {
		case 1:
			return "MONDAY";
		case 2:
			return "TUESDAY";
		case 3:
			return "WEDNESDAY";
		case 4:
			return "THURSDAY";
		case 5:
			return "FRIDAY";
		case 6:
			return "SATURDAY";
		case 7:
			return "SUNDAY";
		default:
			return "Invalid";
		}
		
		
	}

	
}
