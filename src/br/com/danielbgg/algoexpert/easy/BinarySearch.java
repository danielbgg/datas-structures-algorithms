package br.com.danielbgg.algoexpert.easy;

public class BinarySearch {

	public static void binarySearch(int[] array, int target) {
		// Write your code here.
		System.out.println("Interative: " + binarySearchInterative(array, target, 0, array.length - 1));
		System.out.println("Recursive: " + binarySearchRecursive(array, target, 0, array.length - 1));
		System.out.println("Naive: " + binarySearchNaive(array, target, 0, array.length - 1));
	}

	// O(log n) time | O(1) space
	private static int binarySearchInterative(int[] array, int target, int left, int right) {
		while (left <= right) {
			int middle = (left + right) / 2;
			int potentialMatch = array[middle];
			if (potentialMatch == target) {
				return middle;
			} else if (target < potentialMatch) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		return -1;
	}

	// O(log n) time | O(log n) space
	private static int binarySearchRecursive(int[] array, int target, int left, int right) {
		if (left > right) {
			return -1;
		}
		int middle = (left + right) / 2;
		int potentialMatch = array[middle];
		if (potentialMatch == target) {
			return middle;
		} else if (target < potentialMatch) {
			return binarySearchRecursive(array, target, left, middle - 1);
		} else {
			return binarySearchRecursive(array, target, middle + 1, right);
		}
	}

	// O(log n) time | O(log n) space
	private static int binarySearchNaive(int[] array, int target, int initialIndex, int finalIndex) {
		int middle = Math.floorDiv(finalIndex - initialIndex, 2) + initialIndex;
		if (middle < 0 || middle >= array.length) {
			return -1;
		}
		int middleValue = array[middle];
		if (middleValue == target) {
			return middle;
		} else if (finalIndex - initialIndex <= 0) {
			return -1;
		} else if (middleValue < target) {
			// redo right side
			return binarySearchNaive(array, target, middle + 1, finalIndex);
		} else {
			// redo left side
			return binarySearchNaive(array, target, initialIndex, middle - 1);
		}
	}

	public static void main(String[] args) {
		BinarySearch.binarySearch(new int[] { 0, 1, 21, 33, 45, 45, 61, 71, 72, 73 }, 73);
	}

}
