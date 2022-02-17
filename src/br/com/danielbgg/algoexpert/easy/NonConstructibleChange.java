package br.com.danielbgg.algoexpert.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class NonConstructibleChange {

	//time: O(n logn) | space: O(1)
	public static int nonConstructibleChange(int[] coins) {
		Arrays.sort(coins);

		int currentChangeCreated = 0;
		for (int coin : coins) {
			if (coin > currentChangeCreated + 1) {
				return currentChangeCreated + 1;
			}
			currentChangeCreated += coin;
		}

		return currentChangeCreated + 1;
	}

	public static int nonConstructibleChangeNaive(int[] coins) {
		// Write your code here.
		LinkedList<Integer> possibleChanges = new LinkedList<Integer>();
		for (int i = 0; i < coins.length; i++) {
			int coin = coins[i];

			int size = possibleChanges.size();
			for (int j = 0; j < size; j++) {
				int possibleChange = possibleChanges.get(j);
				int newPossibleChange = possibleChange + coin;
				possibleChanges.add(newPossibleChange);
			}
			possibleChanges.add(coin);
		}

		Collections.sort(possibleChanges);
		int counter = 0;
		int lastItem = -1;
		for (int i = 0; i < possibleChanges.size(); i++) {
			Integer value = possibleChanges.get(i);

			if (value == lastItem) {
				// repeated!
				continue;
			} else {
				lastItem = value;
				counter++;
				if (value > counter) {
					return counter;
				}
			}
		}
		return ++counter;
	}

	public static void main(String[] args) {
		System.out.println(nonConstructibleChange(new int[] { 5, 7, 1, 1, 2, 3, 22 }));
		System.out.println(nonConstructibleChange(new int[] { 1, 1, 1, 1, 1 }));
	}

}
