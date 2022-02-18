package br.com.danielbgg.algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

public class FindKthLargestValueInBST {

	static class BST {
		public int value;
		public BST left = null;
		public BST right = null;

		public BST(int value) {
			this.value = value;
		}

		public BST insert(int value) {
			BST root = this;
			BST node = new BST(value);

			while (true) {
				if (node.value < root.value) {
					if (root.left == null) {
						root.left = node;
						break;
					} else {
						root = root.left;
					}
				} else {
					if (root.right == null) {
						root.right = node;
						break;
					} else {
						root = root.right;
					}
				}
			}
			return this;
		}
	}

	public static int findKthLargestValueInBst(BST tree, int k) {
		List<Integer> list = traverseReverseOrder(tree, k, new ArrayList<Integer>());
		System.out.println(list);
		return list.get(list.size() - 1);
	}

	// time: O(h + k) | space: O(h)
	private static List<Integer> traverseReverseOrder(BST tree, int k, List<Integer> list) {
		if (tree == null || list.size() >= k)
			return list;

		if (tree.right != null)
			traverseReverseOrder(tree.right, k, list);

		if (list.size() < k)
			list.add(tree.value);

		if (tree.left != null)
			traverseReverseOrder(tree.left, k, list);

		return list;
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
		// TODO Auto-generated method stub
		BST root = new BST(10);
		root.insert(5);
		root.insert(15);
		root.insert(2);
		root.insert(5);
		root.insert(20);
		root.insert(17);
		root.insert(22);
		root.insert(1);
		System.out.println(toString(root));

		System.out.println(findKthLargestValueInBst(root, 2));

	}
}
