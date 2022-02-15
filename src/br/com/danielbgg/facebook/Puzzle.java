package br.com.danielbgg.facebook;

import java.util.Arrays;

public class Puzzle {

	public static String getWrongAnswers(int N, String C) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < N; i++) {
			if (C.charAt(i) == 'A') {
				buffer.append("B");
			} else {
				buffer.append("A");
			}
		}
		return buffer.toString();
	}

	public static double getHitProbability(int R, int C, int[][] G) {
		double numberOfCells = R * C;
		double numberOfShips = 0;
		for (int i = 0; i < G.length; i++) {
			int[] row = G[i];
			for (int j = 0; j < row.length; j++) {
				if (G[i][j] == 1)
					numberOfShips++;
			}
		}
		return numberOfShips / numberOfCells;
	}

	public static long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
		// N = number of seats - 1 to N
		// K = space between seats
		// M = number of clients
		// S = position of the seats

		// Write your code here
		int[] row = new int[(int) N];
		for (int i = 0; i < S.length; i++) {
			// place seat
			int seat = (int) S[i] - 1;
			row[seat] = 1;

			// place K
			for (int j = 1; j <= K; j++) {
				if (seat + j < N) {
					row[seat + j] = 2;
				}
				if (seat - j >= 0) {
					row[seat - j] = 2;
				}
			}
		}
		System.out.println(Arrays.toString(row));

		
		int counter = 0;
		for (int i = 0; i < N; i++) {
			if (row[i] == 0) {
				row[i] = 3;
				counter++;

				for (int j = 1; j <= K; j++) {
					if (i + j < N) {
						row[i + j] = 4;
					}
					if (i - j >= 0) {
						row[i - j] = 4;
					}
				}

			}
		}

		System.out.println(Arrays.toString(row));

		return (long) counter;
	}

	public static void main(String[] args) {
		System.out.println(Puzzle.getWrongAnswers(3, "ABA"));
		System.out.println(Puzzle.getHitProbability(2, 3, new int[][] { { 0, 0, 1 }, { 1, 0, 1 } }));

		System.out.println(Puzzle.getMaxAdditionalDinersCount(10l, 3l, 1, new long[] { 5 }));

		/*
		System.out.println(Puzzle.getMaxAdditionalDinersCount(10l, 1l, 2, new long[] { 2, 6 }));
		System.out.println(Puzzle.getMaxAdditionalDinersCount(15l, 2l, 3, new long[] { 11, 6, 14 }));
		System.out.println(Puzzle.getMaxAdditionalDinersCount(15l, 1l, 0, new long[] {}));
		System.out.println(Puzzle.getMaxAdditionalDinersCount(16l, 1l, 1, new long[] { 2 }));
		*/
	}

}
