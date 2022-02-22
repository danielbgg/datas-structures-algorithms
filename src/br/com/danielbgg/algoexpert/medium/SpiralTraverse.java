package br.com.danielbgg.algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralTraverse {

	// time: O(n) | space: O(n)
	public static List<Integer> spiralTraverse(int[][] array) {
		int lineCounter = 0;
		int charCounter = 0;
		int rowNum = array.length;
		int colNum = array[0].length;
		int maxChars = rowNum * colNum;
		List<Integer> list = new ArrayList<Integer>();

		while (charCounter < maxChars) {
			System.out.println("char counter: " + charCounter);

			if (lineCounter % 4 == 0) {
				// top
				printTop(array, (lineCounter / 4) + 1, list);
			} else if (lineCounter % 4 == 1) {
				// right
				printRight(array, (lineCounter / 4) + 1, list);
			} else if (lineCounter % 4 == 2) {
				// bottom
				printBottom(array, (lineCounter / 4) + 1, list);
			} else if (lineCounter % 4 == 3) {
				// left
				printLeft(array, (lineCounter / 4) + 1, list);
			}
			charCounter = list.size();
			lineCounter++;
		}
		return list;
	}

	private static void printTop(int[][] array, int layer, List<Integer> list) {
		System.out.println("top - layer " + layer);
		int[] data = array[layer - 1];
		int initialIndex = layer - 1;
		int finalIndex = data.length - layer;
		for (int i = initialIndex; i <= finalIndex; i++) {
			list.add(data[i]);
		}
	}

	private static void printBottom(int[][] array, int layer, List<Integer> list) {
		System.out.println("bottom - layer " + layer);
		int[] data = array[array.length - layer];
		int initialIndex = layer - 1;
		int finalIndex = data.length - layer - 1;
		for (int i = finalIndex; i >= initialIndex; i--) {
			list.add(data[i]);
		}
	}

	private static void printRight(int[][] array, int layer, List<Integer> list) {
		System.out.println("right - layer " + layer);
		int index = array[0].length - layer;
		int initialLine = layer;
		int finalLine = array.length - layer;
		for (int i = initialLine; i <= finalLine; i++) {
			list.add(array[i][index]);
		}
	}

	private static void printLeft(int[][] array, int layer, List<Integer> list) {
		System.out.println("left - layer " + layer);
		int index = layer - 1;
		int initialLine = layer;
		int finalLine = array.length - layer - 1;
		for (int i = finalLine; i >= initialLine; i--) {
			list.add(array[i][index]);
		}
	}

	public static void main(String[] args) {
		List<Integer> result = spiralTraverse(
				new int[][] { { 1, 2, 3, 4 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6 }, { 10, 9, 8, 7 } });
		System.out.println(Arrays.toString(result.toArray()));
	}

}
