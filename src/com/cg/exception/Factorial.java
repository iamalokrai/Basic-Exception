package com.cg.exception;

//Importing the util package
import java.util.*;

//Class extending the Exception Class
class InvalidInputException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	InvalidInputException(String warning) {
		super(warning);
	}
}

// Class extending Exception Class
class FactorialException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	FactorialException(String warning) {
		super(warning);
	}
}

// Class having method to find the factorial
public class Factorial {
	int i;
	long fact = 1;

	// method to find the factorial
	long getFactorial(int num) throws InvalidInputException, FactorialException {
		if (num < 2) {
			throw new InvalidInputException("Wrong Input the no. must be greater than or equal to 2");
		} else {
			for (i = 1; i <= num; i++) {
				fact = fact * i;
				if (fact > Integer.MAX_VALUE) {
					throw new FactorialException(
							"Wrong Input the factorial is greater thhan the highest value of integer");
				}

			}
		}
		return fact;
	}

	// Main class
	public static void main(String[] args) {

		// object of scanner class
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the no. to find the factorial");
		int num = scanner.nextInt();
		Factorial factorial = new Factorial();
		long result;
		// Using try to store the risky codes
		try {
			result = factorial.getFactorial(num);
			System.out.println("The factorial = " + result);
		}
		// Catch to throw exception
		catch (InvalidInputException input) {
			input.printStackTrace();
		} catch (FactorialException facto) {
			facto.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		scanner.close();
	}

}
