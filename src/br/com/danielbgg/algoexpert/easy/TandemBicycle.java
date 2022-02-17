package br.com.danielbgg.algoexpert.easy;

import java.util.Arrays;

public class TandemBicycle {

	//time: O(n logn) | space: O(1)
	public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
		// Write your code here.
		Arrays.sort(redShirtSpeeds);
		Arrays.sort(blueShirtSpeeds);

		int sum = 0;
		int lastIndex = blueShirtSpeeds.length - 1;
		for (int i = 0; i < redShirtSpeeds.length; i++) {
			if (fastest) {
				sum = sum + chooseGreater(redShirtSpeeds[i], blueShirtSpeeds[lastIndex]);
				lastIndex--;
			} else {
				sum = sum + chooseGreater(redShirtSpeeds[i], blueShirtSpeeds[i]);
			}
		}

		return sum;
	}

	private static int chooseGreater(int value1, int value2) {
		return value1 > value2 ? value1 : value2;
	}

	public static void main(String[] args) {
		System.out.println(tandemBicycle(new int[] { 5, 5, 3, 9, 2 }, new int[] { 3, 6, 7, 2, 1 }, false));
		System.out.println(tandemBicycle(new int[] { 5, 5, 3, 9, 2 }, new int[] { 3, 6, 7, 2, 1 }, true));
	}

}
