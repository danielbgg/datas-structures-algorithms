package br.com.danielbgg.algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

public class MinHeightBST {

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
			left = null;
			right = null;
		}

		public void insert(int value) {
			if (value < this.value) {
				if (left == null) {
					left = new BST(value);
				} else {
					left.insert(value);
				}
			} else {
				if (right == null) {
					right = new BST(value);
				} else {
					right.insert(value);
				}
			}
		}
	}

	public static BST minHeightBst(List<Integer> array) {
		return createBST(array, 0, array.size() - 1);
	}

	//time: O(n) | space: O(n)
	private static BST createBST(List<Integer> array, int minIndex, int maxIndex) {
		// grab medium integer
		// create node
		int half = (maxIndex + minIndex) / 2;
		BST root = new BST(array.get(half));

		// grab left array
		// insert node
		// recursive
		int leftMin = minIndex;
		int leftMax = half - 1;
		if (leftMax - leftMin >= 0) {
			root.left = createBST(array,leftMin, leftMax); 
		}
		
		// grab right array
		// insert node
		// recursive
		int rightMin = half+1;
		int rightMax = maxIndex;
		if (rightMax - rightMin >= 0) {
			root.right = createBST(array,rightMin, rightMax); 
		}

		// return created node
		return root;
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
		list.add(1);
		list.add(2);
		list.add(5);
		list.add(7);
		list.add(10);
		list.add(13);
		list.add(14);
		list.add(15);
		list.add(22);
		System.out.println(toString(minHeightBst(list)));

	}

}
