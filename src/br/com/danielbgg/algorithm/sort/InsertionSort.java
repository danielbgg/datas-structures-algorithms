package br.com.danielbgg.algorithm.sort;

import java.util.Arrays;

public class InsertionSort {

	public static int[] insertionSort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;

			// Move elements of arr[0..i-1], that are greater than key, to one position
			// ahead of their current position
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
		return arr;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(InsertionSort.insertionSort(new int[] { 6, 5, 3, 1, 8, 7, 2, 4 })));
		System.out.println(
				Arrays.toString(InsertionSort.insertionSort(new int[] { 99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0 })));
	}

}
