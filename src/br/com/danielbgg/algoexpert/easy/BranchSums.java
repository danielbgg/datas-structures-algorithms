package br.com.danielbgg.algoexpert.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BranchSums {

	public static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		BinaryTree(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	//time: O(n) | space: O(n)
	public static List<Integer> branchSums(BinaryTree root) {
		// Write your code here.
		LinkedList<Integer> list = new LinkedList<Integer>();
		dps(root, list, 0);
		return list;
	}

	private static void dps(BinaryTree node, List<Integer> list, int sumOfBranch) {
		if (node.left == null && node.right == null) {
			int sum = sumOfBranch + node.value;
			list.add(sum);
		}
		if (node.left != null) {
			int sumOfLeft = sumOfBranch + node.value;
			dps(node.left, list, sumOfLeft);
		}

		if (node.right != null) {
			int sumOfRight = sumOfBranch + node.value;
			dps(node.right, list, sumOfRight);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree(1);

		tree.left = new BinaryTree(2);

		tree.left.left = new BinaryTree(4);

		tree.left.left.left = new BinaryTree(8);
		tree.left.left.right = new BinaryTree(9);

		tree.left.right = new BinaryTree(5);
		tree.left.right.left = new BinaryTree(10);
		
		tree.right = new BinaryTree(3);
		tree.right.left = new BinaryTree(6);
		tree.right.right = new BinaryTree(7);

		System.out.println(Arrays.toString(branchSums(tree).toArray()));

	}

}
