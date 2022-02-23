package br.com.danielbgg.algoexpert.medium;

public class InvertBinaryTree {

	static class BinaryTree {
		public int value;
		public BinaryTree left;
		public BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	public static String toString(BinaryTree root) {
		StringBuilder buffer = new StringBuilder(50);
		print(root, buffer, "", "");
		return buffer.toString();
	}

	private static void print(BinaryTree n, StringBuilder buffer, String prefix, String childrenPrefix) {
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

	//time: O(n) | space: O(d) depth/height
	public static void invertBinaryTree(BinaryTree tree) {
		if (tree == null) {
			return;
		}
		BinaryTree left = tree.left;
		BinaryTree right = tree.right;
		tree.right = left;
		tree.left = right;
		
		invertBinaryTree(left);
		invertBinaryTree(right);
	}

	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(1);
		root.left = new BinaryTree(2);
		root.left.left = new BinaryTree(4);
		root.left.left.left = new BinaryTree(8);
		root.left.left.right = new BinaryTree(9);
		root.left.right = new BinaryTree(5);
		root.right = new BinaryTree(3);
		root.right.left = new BinaryTree(6);
		root.right.right = new BinaryTree(7);
		System.out.println(toString(root));
		invertBinaryTree(root);
		System.out.println(toString(root));
	}
}
