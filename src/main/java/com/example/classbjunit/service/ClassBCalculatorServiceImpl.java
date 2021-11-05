package com.example.classbjunit.service;

public class ClassBCalculatorServiceImpl {

	CalculatorService calcService;

	public void setCalcService(CalculatorService calcService) {
		this.calcService = calcService;
	}

	public int calcSumForServiceData() {
		int sum = 0;
		for (int value : calcService.getAll()) {
			sum += value;
		}
		return sum;
	}
	public int calcSum(int[] data) {

		int sum = 0;

		for (int value : data) {
			sum += value;
		}

		return sum;
	}

	
}
