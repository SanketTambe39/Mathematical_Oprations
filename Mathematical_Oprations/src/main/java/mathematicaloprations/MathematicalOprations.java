package mathematicaloprations;

import java.util.Scanner;

public class MathematicalOprations {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter two numbers on which you want to perform the oprations ::");
		
		System.out.println("Enter Value of 1st number :: ");
		int firstNumber = scanner.nextInt();
		System.out.println("Enter Value of 1st number :: ");
		int secondNumber = scanner.nextInt();
		scanner.close();
		// defining some lambda function to perform math operations
		MyMathFunction add = Integer::sum;
		MyMathFunction Subtract = (x, y) -> (x - y);
		MyMathFunction Multiply = (x, y) -> (x * y);
		MyMathFunction Division = (x, y) -> (x / y);

		// calling and printing values returned by functions
		System.out.println("Addition is " + add.calculate(firstNumber, secondNumber));
		System.out.println("Subtract is " + Subtract.calculate(firstNumber, secondNumber));
		System.out.println("Multiply is " + Multiply.calculate(firstNumber, secondNumber));
		System.out.println("Divide is " + Division.calculate(firstNumber, secondNumber));
	}

}
