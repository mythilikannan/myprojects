package model;

import entities.Expenses;

public class CalculationModel {
	
	public static double taxCalculation(Expenses expense)
	{
		double tax = expense.getAmount() * 0.2 % 100;
		double afterTax = expense.getAmount() + tax;
		
		return afterTax;
	}

}
