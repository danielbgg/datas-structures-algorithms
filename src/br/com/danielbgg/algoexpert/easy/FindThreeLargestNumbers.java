package br.com.danielbgg.algoexpert.easy;

import java.util.Arrays;

public class FindThreeLargestNumbers {

	//time: O(n) | space: O(1);
	public static int[] findThreeLargestNumbers(int[] array) {
		// Write your code here.
		int[] temp = Arrays.copyOf(array, 3);
		sort(temp);
		for (int i = 3; i < array.length; i++) {
			updateLargestNumbers(temp, array[i]);
		}
		return temp;
	}

	private static void updateLargestNumbers(int[] array, int newNumber) {
		for (int i = 0; i <array.length; i++) {
			int value = array[i];
			if (newNumber > value) {
				array[i] = newNumber;
				sort(array);
				break;
			}
		}
	}

	private static void sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				if (array[i] > array[j]) {
					int i1 = array[i];
					int j1 = array[j];
					array[j] = i1;
					array[i] = j1;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(
				Arrays.toString(findThreeLargestNumbers(new int[] { 141, 1, 17, -7, -17, -27, 18, 541, 8, 7 })));
	}

}
