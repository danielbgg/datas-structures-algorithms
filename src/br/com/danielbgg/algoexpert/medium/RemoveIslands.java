package br.com.danielbgg.algoexpert.medium;

import java.util.Arrays;

public class RemoveIslands {

	//time: O(w*h) | space: (w*h) - width and height of the input matrix
	public static int[][] removeIslands(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			int[] line = matrix[i];

			if (i == 0 || i == matrix.length - 1) {
				for (int j = 0; j < line.length; j++) {
					if (matrix[i][j] == 1) {
						dps(i, j, matrix);
					}
				}
			} else {
				for (int j = 0; j < line.length; j = j + line.length - 1) {
					if (matrix[i][j] == 1) {
						dps(i, j, matrix);
					}
				}
			}

		}
		paint(matrix);
		return matrix;
	}

	private static void paint(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 1) {
					matrix[i][j] = 0;
				} else if (matrix[i][j] == 2) {
					matrix[i][j] = 1;
				}
			}
		}
	}

	private static void dps(int line, int row, int[][] matrix) {
		matrix[line][row] = 2;

		if (line - 1 > 0) {
			if (matrix[line - 1][row] == 1) {
				dps(line - 1, row, matrix);
			}
		}

		if (line + 1 < matrix.length - 1) {
			if (matrix[line + 1][row] == 1) {
				dps(line + 1, row, matrix);
			}
		}

		if (row - 1 > 0) {
			if (matrix[line][row - 1] == 1) {
				dps(line, row - 1, matrix);
			}
		}

		if (row + 1 < matrix[line].length - 1) {
			if (matrix[line][row + 1] == 1) {
				dps(line, row + 1, matrix);
			}
		}

	}

	public static void main(String[] args) {
		int[][] matrix = removeIslands(new int[][] { { 1, 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 1, 1 }, { 0, 0, 1, 0, 1, 0 },
				{ 1, 1, 0, 0, 1, 0 }, { 1, 0, 1, 1, 0, 0 }, { 1, 0, 0, 0, 0, 1 } });
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}

}
