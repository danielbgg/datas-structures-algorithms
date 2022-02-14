package br.com.danielbgg.algorithm.sort;

import java.util.Arrays;

public class QuickSort {
	
	public static int value = -1;
	public static boolean started = false;
	
	public static int[] quickSort(int[] values, int left, int right) {
		// base case
		if (values.length == 1 || right < 1) {
			return values;
		}

		int fixedPosition = swap(values, left, right);

		System.out.println("position:" + fixedPosition);
		if (value == -1) {
			value = fixedPosition;
		}

		// left
		quickSort(values, 0, fixedPosition - 1);
				
		// right
		if (started) {
			quickSort(values, fixedPosition + 1, values.length - 1);
		} else {
			started = true;
			quickSort(values, value + 1, values.length - 1);
		}

		// 6, 5, 3, 9, 1, 8, 7, 2, 4

		System.out.println(fixedPosition);

		return values;
	}

	private static int swap(int[] values, int left, int right) {
		int pivot = values[right];
		int fixedPosition = right;
		for (int i = right; i >= left; i--) {
			if (values[i] > pivot) {
				int temp = values[i];
				values[i] = values[fixedPosition];
				values[fixedPosition] = temp;
				fixedPosition = fixedPosition - 1;
			}
		}
		return fixedPosition;
	}

	public static int[] quickSort(int[] values) {
		return quickSort(values, 0, values.length - 1);
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(QuickSort.quickSort(new int[] { 6, 5, 3, 9, 1, 8, 7, 2, 4 })));
		// System.out.println(Arrays.toString(QuickSort.quickSort(new int[] { 99, 44, 6,
		// 2, 1, 5, 63, 87, 283, 4, 44, 55, 26, 847, 12, 31, 43, 140 })));
	}

}