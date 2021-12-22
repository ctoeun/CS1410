package a1; // CS1410 Assignment 1: Driving Cost Calculator by Cobi Toeun

public class DrivingCostCalculator {

	public static void displayBanner() {
		
		System.out.println("--------------------------");
		System.out.println(" Driving Cost Calculator: "); // displays banner and outputs driving cost calculator
		System.out.println("--------------------------");
		System.out.println("");
		
	}
	
	public static double calculateGasTripCost(double milesToDrive, double milesPerGallon, double dollarsPerGallon) {
		
		return milesToDrive * dollarsPerGallon / milesPerGallon; // returns equation for gas trip cost to main method

	}
	
	public static double calculateElectricTripCost(double milesToDrive, double milesPerKWh, double dollarsPerKWh) {
		
		return milesToDrive * dollarsPerKWh / milesPerKWh; // returns equation for electric trip cost to main method
	}
	
	public static void main(String args[]) {
		
		double milesToDrive = 100.0;
		double milesPerGallon = 20.0;
		double dollarsPerGallon = 2.46; // variables and inputs
		double milesPerKwh = 4.0;
		double dollarsPerKwh = 0.106;
		double costOfGas = calculateGasTripCost(milesToDrive, milesPerGallon, dollarsPerGallon); // created variables for return statements
		double costOfElectric = calculateElectricTripCost(milesToDrive, milesPerKwh, dollarsPerKwh);
		
		String gasCost = String.format("%.2f", costOfGas); // string for formatting costs to two decimal places
		String electricCost = String.format("%.2f", costOfElectric);
		
		displayBanner(); // returns and displays banner
		
		System.out.println("The cost of a " + milesToDrive + " mile trip by gas is $" + gasCost + " and by electric is $" + electricCost);
	}

}
