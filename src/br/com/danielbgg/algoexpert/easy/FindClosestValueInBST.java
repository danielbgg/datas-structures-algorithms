package br.com.danielbgg.algoexpert.easy;

public class FindClosestValueInBST {

	public static int findClosestValueInBst(BST tree, int target) {
		BST currentNode = tree;
		int closest = tree.value;
		while (currentNode != null) {
			if (Math.abs(target - closest) > Math.abs(target - currentNode.value)) {
				closest = currentNode.value;
			}
			if (target < currentNode.value) {
				currentNode = currentNode.left;
			} else if (target > currentNode.value) {
				currentNode = currentNode.right;
			} else {
				break;
			}
		}
		return closest;
	}

	public static int findClosestValueInBstNaive(BST tree, int target) {
		BST node = tree;
		BST parent = tree;
		BST grandParent = tree;

		while (true) {
			// exit point

			if (node == null) {
				// compare grand parent value and parent value

				int v1 = Math.abs(grandParent.value - target);
				int v2 = Math.abs(target - parent.value);
				if (v2 > v1) {
					return grandParent.value;
				} else {
					return parent.value;
				}
			} else if (node.value == target) {
				return node.value;
			} else if (target < node.value) {
				// left
				grandParent = parent;
				parent = node;
				node = node.left;
			} else {
				// right
				grandParent = parent;
				parent = node;
				node = node.right;
			}
		}
	}

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST tree = new BST(10);
		tree.left = new BST(5);
		tree.left.left = new BST(2);
		tree.left.right = new BST(5);
		tree.left.left.left = new BST(1);

		tree.right = new BST(15);
		tree.right.left = new BST(13);
		tree.right.left.right = new BST(14);
		tree.right.right = new BST(22);

		System.out.println(findClosestValueInBst(tree, 8));

	}

}
