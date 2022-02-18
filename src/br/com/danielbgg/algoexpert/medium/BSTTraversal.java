package br.com.danielbgg.algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

public class BSTTraversal {

	static class BST {
		public int value;
		public BST left;
		public BST right;

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

	public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
		if (tree != null && tree.left != null) {
			inOrderTraverse(tree.left, array);
		}
		array.add(tree.value);
		if (tree != null && tree.right != null) {
			inOrderTraverse(tree.right, array);
		}
		return array;
	}

	public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
		array.add(tree.value);
		if (tree != null && tree.left != null) {
			preOrderTraverse(tree.left, array);
		}
		if (tree != null && tree.right != null) {
			preOrderTraverse(tree.right, array);
		}
		return array;
	}

	public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
		if (tree != null && tree.left != null) {
			postOrderTraverse(tree.left, array);
		}
		if (tree != null && tree.right != null) {
			postOrderTraverse(tree.right, array);
		}
		array.add(tree.value);
		return array;
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
		root.insert(22);
		root.insert(1);
		System.out.println(toString(root));

		System.out.println(inOrderTraverse(root, new ArrayList<Integer>()));
		System.out.println(preOrderTraverse(root, new ArrayList<Integer>()));
		System.out.println(postOrderTraverse(root, new ArrayList<Integer>()));

	}

}
