package br.com.danielbgg.algoexpert.easy;

public class NodeDepths {

	static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
			left = null;
			right = null;
		}
	}

	//time: O (n) | space: O (h)
	public static int nodeDepths(BinaryTree root) {
		// Write your code here.
		return traverse(root, 0, 0);
	}

	private static int traverse(BinaryTree node, int level, int sum) {
		int newLevel = level + 1;
		sum = sum + level;
		if (node.left != null) {
			sum = traverse(node.left, newLevel, sum);
		}
		if (node.right != null) {
			sum = traverse(node.right, newLevel, sum);
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree(1);

		tree.left = new BinaryTree(2);

		tree.left.left = new BinaryTree(4);
		tree.left.right = new BinaryTree(5);

		tree.left.left.left = new BinaryTree(8);
		tree.left.left.right = new BinaryTree(9);

		tree.right = new BinaryTree(3);
		tree.right.left = new BinaryTree(6);
		tree.right.right = new BinaryTree(7);

		System.out.println(nodeDepths(tree));
	}

}
