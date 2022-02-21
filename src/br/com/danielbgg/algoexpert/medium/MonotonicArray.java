package br.com.danielbgg.algoexpert.medium;

public class MonotonicArray {

	//time: O(n) | space: O(1)
	public static boolean isMonotonic(int[] array) {
		if (array == null || array.length <= 1) {
			return true;
		}

		boolean isMonotonic = true;
		Boolean increasing = null;

		for (int i = 0; i < array.length - 1; i++) {
			int value = array[i];
			int nextValue = array[i+1];
			int diff = nextValue - value;

			if (diff == 0) {
				continue;
			} else if (diff > 0) {
				if (increasing == null) {
					increasing = true;
				} else {
					if (!increasing) {
						isMonotonic = false;
						break;
					}
				}
			} else {
				if (increasing == null) {
					increasing = false;
				} else {
					if (increasing) {
						isMonotonic = false;
						break;
					}
				}
			}
		}
		return isMonotonic;
	}

	public static void main(String[] args) {
		System.out.println(isMonotonic(new int[] { -1, -5, -10, -1100, -1100, -1101, -1102, -9001 }));
	}

}
