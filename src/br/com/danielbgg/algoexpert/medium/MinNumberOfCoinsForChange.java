package br.com.danielbgg.algoexpert.medium;

import java.util.Arrays;

public class MinNumberOfCoinsForChange {

	// time: O(n*d) | space: O(n) --> d size of denoms
	public static int numberOfWaysToMakeChange(int n, int[] denoms) {
		int[] numOfCoins = new int[n + 1];
		Arrays.fill(numOfCoins, Integer.MAX_VALUE);
		numOfCoins[0] = 0;
		int toCompare = 0;
		for (int denom : denoms) {
			for (int amount = 0; amount < numOfCoins.length; amount++) {
				if (denom <= amount) {
					if (numOfCoins[amount - denom] == Integer.MAX_VALUE) {
						toCompare = numOfCoins[amount - denom];
					} else {
						toCompare = numOfCoins[amount - denom] + 1;
					}
					numOfCoins[amount] = Math.min(numOfCoins[amount], toCompare);
				}
			}
		}
		return numOfCoins[n] != Integer.MAX_VALUE ? numOfCoins[n] : -1;
	}

	public static void main(String[] args) {
		System.out.println(numberOfWaysToMakeChange(3, new int[] { 2, 1 }));
	}

}
