package br.com.danielbgg.algoexpert.medium;

import java.util.ArrayList;

public class ReconstructBST {

	private int rootIndex = 0;
	
	static class BST {
		public int value;
		public BST left = null;
		public BST right = null;

		public BST(int value) {
			this.value = value;
		}
	}

	//time: O(n) | space: O(n)
	public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
		return createNode(preOrderTraversalValues, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private BST createNode(ArrayList<Integer> values, int minValue, int maxValue) {
		if (rootIndex < values.size() && values.get(rootIndex) >= minValue && values.get(rootIndex) < maxValue) {
			BST node = new BST(values.get(rootIndex));
			rootIndex++;
			node.left = createNode(values, minValue, node.value);
			node.right = createNode(values, node.value, maxValue);
			return node;
		}
		return null;
	}

	public static String toString(BST root) {
		StringBuilder buffer = new StringBuilder(50);
		print(root, buffer, "", "");
		return buffer.toString();
	}

	private static void print(BST n, StringBuilder buffer, String prefix, String childrenPrefix) {
		buffer.append(prefix);
		buffer.append(n.value);
		buffer.append('\n');

		if (n.left != null) {
			print(n.left, buffer, childrenPrefix + "--- ", childrenPrefix + "|   ");
		}
		if (n.right != null) {
			print(n.right, buffer, childrenPrefix + "+++ ", childrenPrefix + "|   ");
		}

	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(4);
		list.add(2);
		list.add(1);
		list.add(5);
		list.add(17);
		list.add(19);
		list.add(18);
		ReconstructBST r = new ReconstructBST();
		BST root = r.reconstructBst(list);
		System.out.println(toString(root));
	}

}
