package br.com.danielbgg.algoexpert.easy;

import java.util.Arrays;

public class SelectionSort {

	// time: O(n^2) | space: O(1)
	public static int[] selectionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int small = i;
			for (int j = i; j < array.length; j++) {
				if (array[small] > array[j]) {
					small = j;
				}
			}
			swap(small, i, array);
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
		System.out.println(Arrays.toString(selectionSort(new int[] { 8, 5, 2, 9, 5, 6, 3 })));
	}
}
