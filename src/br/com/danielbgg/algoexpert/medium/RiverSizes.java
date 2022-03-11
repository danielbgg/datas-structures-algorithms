package br.com.danielbgg.algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

public class RiverSizes {

	//time: O(w*h) | space: (w*h) - width and height of the input matrix
	public static List<Integer> riverSizes(int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < matrix.length; i++) {
			int[] line = matrix[i];

			for (int j = 0; j < line.length; j++) {
				if (matrix[i][j] == 1) {
					int sum = dps(i, j, matrix, list, 0);
					list.add(sum);
				}
			}
		}

		return list;
	}

	private static int dps(int line, int row, int[][] matrix, List<Integer> list, int sum) {
		matrix[line][row] = 2;

		int internalSum = ++sum;

		if (line - 1 >= 0) {
			if (matrix[line - 1][row] == 1) {
				internalSum = dps(line - 1, row, matrix, list, internalSum);
			}
		}

		if (line + 1 < matrix.length) {
			if (matrix[line + 1][row] == 1) {
				internalSum = dps(line + 1, row, matrix, list, internalSum);
			}
		}

		if (row - 1 >= 0) {
			if (matrix[line][row - 1] == 1) {
				internalSum = dps(line, row - 1, matrix, list, internalSum);
			}
		}

		if (row + 1 < matrix[line].length) {
			if (matrix[line][row + 1] == 1) {
				internalSum = dps(line, row + 1, matrix, list, internalSum);
			}
		}

		return internalSum;

	}

	public static void main(String[] args) {
		List<Integer> list = riverSizes(new int[][] { { 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0 },
				{ 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0 }, { 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1 },
				{ 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0 }, { 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1 } });
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
