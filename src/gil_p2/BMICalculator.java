package gil_p2;
import java.util.Scanner;

public class BMICalculator {
	Scanner input = new Scanner(System.in);
	private int metricOrImperial;
	private int negEntered;
	private int bmiCategory;
	private double height;
	private double weight;
	private double bmi;
	
	// exits if the user enters a negative height or weight
	// (actually I don't know how to exit so it just doesn't print anything lol
	
	// makes use of readUnitType and readMeasurementData
	public void readUserData () {
		this.readUnitType();
		this.readMeasurementData();
		
	}
	
	// calculates user's Bmi and Bmi category
	public void calculateBmi () {
		if (this.metricOrImperial == 0) {
			this.bmi = this.getWeight() / (this.getHeight() * this.getHeight());
		}
		else this.bmi = 703 * this.getWeight() / ( this.getHeight() * this.getHeight());
		this.calculateBmiCategory();
	}
	
	// prints the Bmi category and value to the standard output
	public void displayBmi() {
		if (this.negEntered < 0) {
			System.out.printf("Your BMI is: %.2f\n", this.getBmi());
			
			if (this.getBmiCategory() == 1) {
				System.out.println("Your BMI Category is: Underweight.");
			}
			else if (this.getBmiCategory() == 2) {
				System.out.println("Your BMI Category is: Normal weight.");
			}
			else if (this.getBmiCategory() == 3) {
				System.out.println("Your BMI Category is: Overweight.");
			}
			else if (this.getBmiCategory() == 4) {
				System.out.println("Your BMI Category is: Obesity.");
			}
		}
	}
	
	// user prompted to enter type of units until they enter a correct value
	private void readUnitType() {
		System.out.println("Enter 0 for Metric or 1 for Imperial.");
		this.metricOrImperial = input.nextInt();
		while (this.metricOrImperial != 0 && this.metricOrImperial != 1) {
			System.out.println("Incorrect value, try again.");
			System.out.println("Enter 0 for Imperial or 1 for Metric.");
			this.metricOrImperial = input.nextInt();
		}
	}
	
	// calls either readMetricData or readImperialData, depending on unit type
	private void readMeasurementData() {
		if (this.metricOrImperial == 0) {
			this.readMetricData();
		}
		else this.readImperialData();
	}
	
	// takes weight and height in metric
	private void readMetricData() {
		System.out.println("Enter weight in kilograms.");
		this.setWeight(input.nextDouble());
		if (this.weight > 0)
		{
			negEntered = -1;
		}
		else negEntered = 1;
		System.out.println("Enter height in meters.");
		this.setHeight(input.nextDouble());
		if (this.height > 0)
		{
			negEntered = -1;
		}
	}
	
	// takes weight and height in imperial
	private void readImperialData() {
		System.out.println("Enter weight in pounds.");
		this.weight = input.nextDouble();
		if (this.weight > 0)
		{
			negEntered = -1;
		}
		else negEntered = 1;
		System.out.println("Enter height in inches.");
		this.height = input.nextDouble();
		if (this.height > 0)
		{
			negEntered = -1;
		}
	}
	
	// determines the user's Bmi category
	private void calculateBmiCategory () {
		if (this.bmi < 18.5) {
			this.bmiCategory = 1;
		}
		else if (this.bmi < 25) {
			this.bmiCategory = 2;
		}
		else if (this.bmiCategory < 30) {
			this.bmiCategory = 3;
		}
		else this.bmiCategory = 4;
	}
	
	public double getWeight () {
		return this.weight;
	}
	
	// sets the weight of the user
	private void setWeight (double weight) {
		this.weight = weight;
	}
	
	// returns the height of the user
	public double getHeight () {
		return this.height;
	}
	
	// sets the weight of the user
	private void setHeight (double height) {
		this.height = height;
	}
	
	// returns the bmi of the user
	public double getBmi () {
		return this.bmi;
	}
	
	// returns the bmi category of the user 1-underweight, 2-normal weight, 3-overweight, 4-obesity
	public int getBmiCategory() {
		return this.bmiCategory;
	}
	
}
