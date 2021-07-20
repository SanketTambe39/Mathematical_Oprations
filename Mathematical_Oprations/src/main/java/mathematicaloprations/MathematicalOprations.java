package mathematicaloprations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

		// passing lambda function as function parameter
		System.out.println("\nAfter using lambda functions as function parameter");
		MyMathFunction.printResult("Addition", firstNumber, secondNumber, add);
		MyMathFunction.printResult("Subtract", firstNumber, secondNumber, Subtract);
		MyMathFunction.printResult("Multiply", firstNumber, secondNumber, Multiply);
		MyMathFunction.printResult("Divide", firstNumber, secondNumber, Division);

		// creating Number list
		List<Integer> numberList = new ArrayList<Integer>();
		for (int i = 0; i < 6; i++) {
			numberList.add(i);
		}

		// method 1 using iterator
		System.out.println("\nNumbers using Iterator");
		Iterator<Integer> it = numberList.iterator();
		// number list using iterator
		while (it.hasNext()) {
			Integer integer = it.next();
			System.out.println(integer);
		}

		// method 2 using consumer interface
		class Myconsumer implements Consumer<Integer> {
			public void accept(Integer t) {
				System.out.println(t);
			}
		}

		Myconsumer action = new Myconsumer();
		System.out.println("\nNumbers using consumer interface");
		numberList.forEach(action);

		// method 3 Traversing using anonymous consumer
		System.out.println("\nNumbers using anonymous consumer");
		numberList.forEach(new Consumer<Integer>() {
			public void accept(Integer t) {
				System.out.println(t);
			}
		});

		// method 4 explicit lambda function
		System.out.println("\nNumbers using explicit lambda");
		Consumer<Integer> numberListAction = n -> {
			System.out.println(n);
		};
		numberList.forEach(numberListAction);

		// method 5 implicit lambda function
		System.out.println("\nNumbers using implicit lambda");
		numberList.forEach(n -> {
			System.out.println(n);
		});

		// method 6 using functional interface to convert integer to string
		System.out.println("Converting number list into double value");
		Function<Integer, Double> doubleFunction = Integer::doubleValue;
		numberList.forEach(n -> {
			System.out.println(doubleFunction.apply(n));
		});
		// method 7 check even number in list
		System.out.println("\nCheck Even number in list and printing them");
		Predicate<Integer> checkEven = n -> n % 2 == 0;
		numberList.forEach(n -> {
			if (checkEven.test(n)) {
				System.out.println("Value ::" + n);
			}
		});
		// uc 2.1 iterate number using streams
		System.out.println("\nNumbers printed using streams are");
		numberList.stream().forEach(n -> {
			System.out.println(n);
		});

		// uc 2.2 transform integer into double
		System.out.println("\nNumbers converted into double using stream are ");
		numberList.stream().map(Integer::doubleValue) // converting integer to double
				.forEach(n -> System.out.println(n)); // printing converted values
		
		// uc 2.3 transform integer into double and store them in list
		System.out.println("\nNumbers converted into double using stream and store them to list ");
		List<Double> doublelist = numberList.stream().map(Integer::doubleValue) // converting integer to double
				.collect(Collectors.toList()); // storing converted values into new list
		System.out.println("value in new list are " + doublelist);

	}

}
