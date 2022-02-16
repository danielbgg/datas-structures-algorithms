package br.com.danielbgg.algoexpert.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoNumberSum {

	public static int[] twoNumberSum(int[] array, int targetSum) {
		// Write your code here.
		// O(n) time | O(n) space
		Map<Integer, Boolean> cache = new HashMap<Integer, Boolean>();
		for (int i = 0; i < array.length; i++) {
			int otherNum = targetSum - array[i];
			if (cache.get(array[i]) == null) {
				cache.put(otherNum, true);
			} else {
				return new int[] { array[i], otherNum };
			}
		}
		return new int[0];
	}
}
