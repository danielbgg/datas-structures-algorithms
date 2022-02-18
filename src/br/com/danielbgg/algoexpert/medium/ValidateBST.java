package br.com.danielbgg.algoexpert.medium;

public class ValidateBST {

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

	//time: O(n) | space: O(h) height of the BST
	public static boolean validateBst(BST tree) {
		return validadeBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean validadeBST(BST tree, int minValue, int maxValue) {
		if (tree.value < minValue || tree.value >= maxValue) {
			return false;
		}
		if (tree.left != null && !validadeBST(tree.left, minValue, tree.value)) {
			return false;
		}
		if (tree.right != null && !validadeBST(tree.right, tree.value, maxValue)) {
			return false;
		}
		return true;
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
		root.insert(13);
		root.insert(22);
		root.insert(1);
		root.insert(14);
		root.insert(12);
		root.insert(27);
		System.out.println(toString(root));
		System.out.println(validateBst(root));

	}

}
