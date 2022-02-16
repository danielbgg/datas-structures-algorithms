package br.com.danielbgg.algoexpert.easy;

import java.util.Arrays;

public class MinimumWaitingTime {

	//time: O(n log n) | space: (1)
	public static int minimumWaitingTime(int[] queries) {
		// Write your code here.
		
		Arrays.sort(queries);

		int sum = 0;
		int total = 0;

		for (int i = 0; i < queries.length - 1; i++) {
			int value = queries[i];
			sum = sum + value;
			total = total + sum;
		}

		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minimumWaitingTime(new int[] { 1, 2, 2, 3, 6 }));
		System.out.println(minimumWaitingTime(new int[] { 3, 2, 1, 2, 6 }));
		// System.out.println(minimumWaitingTime(new int[] {5,1,4}));

	}

}
