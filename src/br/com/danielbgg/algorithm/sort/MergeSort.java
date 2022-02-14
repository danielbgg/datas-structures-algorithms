package br.com.danielbgg.algorithm.sort;

import java.util.Arrays;

public class MergeSort {

	public static int[] mergeSort(int[] values) {
		if (values.length == 1)
			return values;

		// split array into right and left
        int[] left = Arrays.copyOfRange(values, 0, (values.length + 1)/2);
        int[] right = Arrays.copyOfRange(values, (values.length + 1)/2, values.length);
	
		return merge(mergeSort(left), mergeSort(right));
	}

	public static int[] merge(int[] array1, int[] array2) {
		//check inputs
		if (array1 == null || array1.length == 0) {
			return array2;
		}
		if (array2 == null || array2.length == 0) {
			return array1;
		}
		
		int[] newArray = new int[array1.length + array2.length];
		for (int i = 0, index1 = 0, index2 = 0; i < (array1.length + array2.length); i++) {
			if (index1 >= array1.length) {
				newArray[i] = array2[index2];
				index2++;
			} else if (index2 >= array2.length) {
				newArray[i] = array1[index1];
				index1++;
			} else if (array1[index1] > array2[index2]) {
				newArray[i] = array2[index2];
				index2++;
			} else {
				newArray[i] = array1[index1];
				index1++;
			}
		}
		System.out.println("MERGING: " + Arrays.toString(array1) + " "+ Arrays.toString(array2) + " --> " + Arrays.toString(newArray));
		return newArray;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(MergeSort.mergeSort(new int[] { 6, 5, 3, 9, 1, 8, 7, 2, 4 })));
		System.out.println(Arrays.toString(MergeSort.mergeSort(new int[] { 99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 44, 55, 26, 847, 12, 31, 43, 140 })));
	}

}