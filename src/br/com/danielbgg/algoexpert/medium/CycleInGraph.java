package br.com.danielbgg.algoexpert.medium;

import java.util.Arrays;

public class CycleInGraph {

	private static int WHITE = 0;
	private static int GREY = 1;
	private static int BLACK = 3;

	// time: O(v+e) | space: O(v)
	public static boolean cycleInGraph(int[][] edges) {
		int numberOfNodes = edges.length;
		int[] colors = new int[numberOfNodes];
		Arrays.fill(colors, WHITE);

		for (int node = 0; node < numberOfNodes; node++) {
			if (colors[node] != WHITE) {
				continue;
			}
			boolean containsCyle = traverseAndColorNodes(node, edges, colors);
			if (containsCyle == true) {
				return true;
			}
		}
		return false;
	}

	public static boolean traverseAndColorNodes(int node, int[][] edges, int[] colors) {
		colors[node] = GREY;
		int[] neighbors = edges[node];
		for (int neighbor : neighbors) {
			int neighborColor = colors[neighbor];
			if (neighborColor == GREY) {
				return true;
			}
			if (neighborColor == BLACK) {
				continue;
			}
			boolean containsCycle = traverseAndColorNodes(neighbor, edges, colors);
			if (containsCycle) {
				return true;
			}
		}
		colors[node] = BLACK;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(cycleInGraph(new int[][] { { 1, 3 }, { 2, 3, 4 }, { 0 }, {}, { 2, 5 }, {} }));
	}

}
