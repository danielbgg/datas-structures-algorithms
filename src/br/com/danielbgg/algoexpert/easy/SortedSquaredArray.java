package br.com.danielbgg.algoexpert.easy;

import java.util.Arrays;

public class SortedSquaredArray {

	//time: O(n) | space: O(n)
	public static int[] sortedSquaredArray(int[] array) {
		// Write your code here.
		int[] newArray = new int[array.length];

		int minPointer = 0;
		int maxPointer = array.length - 1;
		int pointer = array.length - 1;

		while (minPointer <= maxPointer) {
			if (Math.abs(array[minPointer]) > Math.abs(array[maxPointer])) {
				newArray[pointer] = array[minPointer] * array[minPointer];
				pointer--;
				minPointer++;
			} else {
				newArray[pointer] = array[maxPointer] * array[maxPointer];
				pointer--;
				maxPointer--;
			}
		}
		return newArray;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortedSquaredArray(new int[] { 1, 2, 3, 5, 6, 8, 9 })));
		System.out.println(Arrays.toString(sortedSquaredArray(new int[] { -10, -8, -5, -2, -1, 0, 8, 9 })));
	}

}
