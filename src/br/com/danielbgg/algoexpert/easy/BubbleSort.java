package br.com.danielbgg.algoexpert.easy;

import java.util.Arrays;

public class BubbleSort {

	public static int[] bubbleSort(int[] array) {
		boolean isSorted = false;
		int counter = 0;
		while (!isSorted) {
			isSorted = true;
			for (int i = 0; i < array.length - 1 - counter; i++) {
				if (array[i] > array[i + 1]) {
					swap(i, i + 1, array);
					isSorted = false;
					System.out.println(Arrays.toString(array));
				}
			}
			counter++;
		}
		return array;
	}

	private static void swap(int i, int j, int[] array) {
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}

	//time: O(n^2) | space: O(1)
	public static int[] bubbleSortNaive(int[] array) {
		// Write your code here.
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i] < array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("METHOD 1");
		System.out.println(Arrays.toString(bubbleSort(new int[] { 8, 5, 2, 9, 5, 6, 3 })));
		System.out.println("METHOD 2");
		System.out.println(Arrays.toString(bubbleSortNaive(new int[] { 8, 5, 2, 9, 5, 6, 3 })));
	}

}
