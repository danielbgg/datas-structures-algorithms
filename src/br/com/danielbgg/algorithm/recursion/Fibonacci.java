package br.com.danielbgg.algorithm.recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	private int calculations = 0;
	private int memo = 0;
	private Map<Integer, Integer> memoization = new HashMap<Integer, Integer>();
	
	
	public int fibonacciDynamicMemoization(int number) {
		//O(n)
		if (number < 2) return number;
		Integer result = memoization.get(number);
		if (result == null) {
			calculations++;
			result = fibonacciDynamicMemoization(number-1) + fibonacciDynamicMemoization(number-2);
			memoization.put(number, result);
			return result; 
		} else {
			memo++;
			return result;
		}
	}
	

	public int fibonacciDynamicBottomUp(int number) {
		//O(n)
		if (number < 2) return number;
		
		int values[] = new int[number+1];
		values[0] = 0;
		values[1] = 1;
		for (int i=2; i<=number; i++) {
			values[i] = values[i-1] + values[i-2];
		}
		return values[number];
	}
	
	
	public int fibonacciRecursive(int number) {
		//O(2^n)
		if (number < 2) return number;
		calculations++;
		return fibonacciRecursive(number-1) + fibonacciRecursive(number-2); 
	}

	public static int fibonacciIterative(int number) {
		if (number < 2) return number;
		
		int values[] = new int[number+1];
		values[0] = 0;
		values[1] = 1;
		for (int i=2; i<=number; i++) {
			values[i] = values[i-1] + values[i-2];
		}
		return values[number];
	}

	public static void main(String[] args) {
//		System.out.println(fibonacciRecursive(8));
//		System.out.println(fibonacciIterative(8));
		
		Fibonacci fibo = new Fibonacci();
		//System.out.println(fibo.fibonacciDynamicMemoization(40));
		System.out.println(fibo.fibonacciRecursive(40));
		System.out.println("calculations: " + fibo.calculations);
		System.out.println("memo: " + fibo.memo);

		System.out.println(fibo.fibonacciDynamicBottomUp(40));
		
	}

}
