package br.com.danielbgg.algoexpert.easy;

import java.util.HashMap;
import java.util.Map;

public class NthFibonacci {

	public static int getNthFib(int n) {
		// Write your code here.
		Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
		return fibonacci(n - 1, cache);
	}

	public static int fibonacci(int position, Map<Integer, Integer> cache) {
		if (position <= 1)
			return position;
		if (cache.get(position) == null) {
			cache.put(position, fibonacci(position - 1, cache) + fibonacci(position - 2, cache));
		}
		return cache.get(position);
	}

	public static int fibonacciInterative(int n) {
		int position = n - 1;
		if (position <= 1)
			return position;
		int temp = 0;
		int last = 0;
		int sum = 1;
		for (int i = 1; i < position; i++) {
			temp = sum;
			sum = sum + last;
			last = temp;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(getNthFib(20));
		System.out.println(fibonacciInterative(20));
	}

}
