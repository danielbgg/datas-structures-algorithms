package br.com.danielbgg.algorithm.sort;

import java.util.Arrays;

public class SelectionSort {

	public static int[] selectionSort(int[] values) {
		for (int i = 0; i < values.length; i++) {

			int index = i;
			int min = values[i];

			for (int j = i; j < values.length; j++) {
				if (values[j] < min) {
					index = j;
					min = values[j];
				}
			}

			int exchange1 = values[i];
			values[i] = values[index];
			values[index] = exchange1;

		}
		return values;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(SelectionSort.selectionSort(new int[] { 8, 5, 2, 6, 9, 3, 1, 4, 0, 7 })));
		System.out.println(Arrays.toString(SelectionSort.selectionSort(new int[] { 6, 5, 3, 1, 8, 7, 2, 4 })));
		System.out.println(
				Arrays.toString(SelectionSort.selectionSort(new int[] { 99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0 })));
	}

}
