package br.com.danielbgg.algoexpert.medium;

public class BinaryTreeDiameter {

	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	static class TreeInfo {
		public int diameter;
		public int height;

		public TreeInfo(int diameter, int height) {
			this.diameter = diameter;
			this.height = height;
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

	// time: O(n) | space: O(h - avarage; n - worst case)
	public static int binaryTreeDiameter(BinaryTree tree) {
		return getTreeInfo(tree).diameter;
	}

	public static TreeInfo getTreeInfo(BinaryTree tree) {
		if (tree == null) {
			return new TreeInfo(0, 0);
		}
		TreeInfo leftTreeInfo = getTreeInfo(tree.left);
		TreeInfo rightTreeInfo = getTreeInfo(tree.right);

		int longestPathThroughRoot = leftTreeInfo.height + rightTreeInfo.height;
		int maxDiameterSoFar = Math.max(leftTreeInfo.diameter, rightTreeInfo.diameter);
		int currentDiameter = Math.max(longestPathThroughRoot, maxDiameterSoFar);
		int currentHeight = 1 + Math.max(leftTreeInfo.height, rightTreeInfo.height);

		return new TreeInfo(currentDiameter, currentHeight);
	}

	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(1);
		root.left = new BinaryTree(3);
		root.left.left = new BinaryTree(7);
		root.left.left.left = new BinaryTree(8);
		root.left.left.left.left = new BinaryTree(9);
		root.left.right = new BinaryTree(4);
		root.left.right.right = new BinaryTree(5);
		root.left.right.right.right = new BinaryTree(6);
		root.right = new BinaryTree(2);
		System.out.println(toString(root));
		System.out.println(binaryTreeDiameter(root));
	}
}
