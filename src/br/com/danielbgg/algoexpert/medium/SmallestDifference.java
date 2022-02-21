package br.com.danielbgg.algoexpert.medium;

import java.util.Arrays;

public class SmallestDifference {

	//time: O(nlogn + mlogm) | space: O(1)
	public static int[] smallestDifferenceSolution2(int[] arrayOne, int[] arrayTwo) {
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		int smallestDifference = Integer.MAX_VALUE;
		int[] pairs = null;

		int pointer1 = 0;
		int pointer2 = 0;

		while (pointer1 < arrayOne.length && pointer2 < arrayTwo.length) {
			int num1 = arrayOne[pointer1];
			int num2 = arrayTwo[pointer2];
			int diff = Math.abs(num1 - num2);
			if (smallestDifference > diff) {
				smallestDifference = diff;
				pairs = new int[] { num1, num2 };
			}

			if (num1 < num2) {
				pointer1++;
			} else {
				pointer2++;
			}

		}
		return pairs;
	}

	public static int[] smallestDifferenceSolution1(int[] arrayOne, int[] arrayTwo) {
		int smallestDifference = Integer.MAX_VALUE;
		int[] pairs = null;
		for (int i = 0; i < arrayOne.length; i++) {
			for (int j = 0; j < arrayTwo.length; j++) {
				int num1 = arrayOne[i];
				int num2 = arrayTwo[j];
				int diff = Math.abs(num1 - num2);
				if (smallestDifference > diff) {
					smallestDifference = diff;
					pairs = new int[] { num1, num2 };
				}
			}
		}
		return pairs;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(
				smallestDifferenceSolution2(new int[] { -1, 5, 10, 20, 28, 3 }, new int[] { 26, 134, 135, 15, 17 })));
	}
}
