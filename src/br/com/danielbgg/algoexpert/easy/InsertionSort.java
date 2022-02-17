package br.com.danielbgg.algoexpert.easy;

import java.util.Arrays;

public class InsertionSort {

	// time: o(n^2) worst case | space: o(1)
	public static int[] insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int j = i; // j is the number to insert
			while (j > 0 && array[j] < array[j - 1]) {
				swap(j, j - 1, array);
				j -= 1;
				System.out.println(Arrays.toString(array));
			}
		}
		return array;
	}

	private static void swap(int i, int j, int[] array) {
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(insertionSort(new int[] { 8, 5, 2, 9, 5, 6, 3 })));
		System.out.println(Arrays.toString(insertionSort(new int[] { 2, 3, 5, 5, 8, 6, 9 })));
	}

}
