package br.com.danielbgg.algoexpert.medium;

import java.util.Arrays;

public class ArrayOfProducts {

	// time: O(n) | space: O(n)
	public static int[] arrayOfProducts(int[] array) {
		int[] products = new int[array.length];
		int[] leftProducts = new int[array.length];
		int[] rightProducts = new int[array.length];

		int leftRunningProduct = 1;
		for (int i = 0; i < array.length; i++) {
			leftProducts[i] = leftRunningProduct;
			leftRunningProduct *= array[i];
		}
		
		int rightRunningProduct = 1;
		for (int i = array.length - 1; i >= 0; i--) {
			rightProducts[i] = rightRunningProduct;
			rightRunningProduct *= array[i];
		}
		
		for (int i = 0; i < array.length; i++) {
			products[i] = leftProducts[i] * rightProducts[i];
		}
		
		return products;
	}

	// time: O(n^2) | space: O(n)
	public static int[] arrayOfProducts2(int[] array) {
		int[] newArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (i == j) {
					continue;
				}
				if (newArray[i] == 0) {
					newArray[i] = array[j];
				} else {
					newArray[i] = newArray[i] * array[j];
				}

			}
		}
		return newArray;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(arrayOfProducts(new int[] { 5, 1, 4, 2 })));
	}

}
