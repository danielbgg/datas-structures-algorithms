package br.com.danielbgg.datastructure.array;

public class MergeSortedArray {

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
		return newArray;
	}

	public static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = new int[] { 0, 3, 4, 31 };
		int[] array2 = new int[] { 4, 6, 30 };
		int[] newArray = merge(array1, array2);
		print(newArray);
	}

}
