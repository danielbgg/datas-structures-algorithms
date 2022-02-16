package br.com.danielbgg.algoexpert.easy;

import java.util.Arrays;
import java.util.List;

public class ValidSubsequence {

	// time: O (M+N) | space: O(1)
	public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
		// Write your code here.
		int sequenceIndex = 0;
		for (int i = 0; i < array.size(); i++) {
			Integer arrayValue = array.get(i);
			if (arrayValue == sequence.get(sequenceIndex)) {
				// match -> increment sequenceIndex
				sequenceIndex++;
				if (sequenceIndex == sequence.size()) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isValidSubsequence(Arrays.stream(new int[] { 5, 1, 22, 25, 6, -1, 8, 10 }).boxed().toList(),
				Arrays.stream(new int[] { 5, 22, 6, 8, 9 }).boxed().toList()));
	}

}
