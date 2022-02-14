package br.com.danielbgg.algorithm.recursion;

public class Factorial {
	
	
	public static int factorialRecursive(int number) {
		if (number <= 1) {
			return 1;
		}
		return number * factorialRecursive(number-1);
	}
	
	public static int factorialIterative(int number) {
		if (number <= 1) {
			return 1;
		}
		int value = 1;
		for (int i=number; i>1; i--) {
			value = value * i;
		}
		return value;
	}
	

	public static void main(String[] args) {
		System.out.println(factorialRecursive(5));
		System.out.println(factorialIterative(5));
	}

}
