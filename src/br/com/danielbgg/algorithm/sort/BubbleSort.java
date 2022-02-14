package br.com.danielbgg.algorithm.sort;

import java.util.Arrays;

public class BubbleSort {

	public static int[] bubbleSort(int[] values) {
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values.length-1; j++) {
				if (values[j] > values[j + 1]) {
					int exchange1 = values[j];
					values[j] = values[j + 1];
					values[j + 1] = exchange1;
				}
			}
		}
		return values;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(BubbleSort.bubbleSort(new int[] { 6, 5, 3, 1, 8, 7, 2, 4 })));
		System.out.println(Arrays.toString(BubbleSort.bubbleSort(new int[] { 99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0 })));
	}

}
