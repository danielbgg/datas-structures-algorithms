package br.com.danielbgg.algoexpert.medium;

public class NumberOfWaysToMakeChange {

	// time: O(n*d) | space: O(n) --> d size of denoms
	public static int numberOfWaysToMakeChange(int n, int[] denoms) {
		int[] ways = new int[n + 1];
		ways[0] = 1;
		for (int denom : denoms) {
			for (int amount = 1; amount < n + 1; amount++) {
				if (denom <= amount) {
					ways[amount] = ways[amount] + ways[amount - denom];
				}
			}
		}
		return ways[n];
	}

	public static void main(String[] args) {
		System.out.println(numberOfWaysToMakeChange(6, new int[] { 1, 5 }));
	}

}
