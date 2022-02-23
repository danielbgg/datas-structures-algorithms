package br.com.danielbgg.algoexpert.medium;

public class FirstDuplicateValue {

	// time: O(n) | space: O(1)
	public static int firstDuplicateValue(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int value = Math.abs(array[i]);
			if (array[value - 1] < 0) {
				return value;
			} else {
				array[value - 1] = array[value - 1] * -1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(firstDuplicateValue(new int[] { 2, 1, 5, 2, 3, 3, 4 }));
		System.out.println(firstDuplicateValue(new int[] { 2, 1, 5, 3, 3, 2, 4 }));
	}

}
