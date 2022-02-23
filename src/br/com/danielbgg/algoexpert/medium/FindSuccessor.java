package br.com.danielbgg.algoexpert.medium;

public class FindSuccessor {

	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;
		public BinaryTree parent = null;

		public BinaryTree(int value) {
			this.value = value;
		}

		public BinaryTree(int value, BinaryTree parent) {
			this.value = value;
			this.parent = parent;
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

	//time: O(h) | space: O(1)
	public static BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
		
		if (node.right != null) {
			return getLeftMostChild(node.right);
		}
		
		return getRightMostParent(node);
	}
	
	public static BinaryTree getLeftMostChild(BinaryTree node) {
		BinaryTree currentNode = node;
		while (currentNode.left != null) {
			currentNode = currentNode.left;
		}
		return currentNode;
	}
	
	public static BinaryTree getRightMostParent(BinaryTree node) {
		BinaryTree currentNode = node;
		while (currentNode.parent != null && currentNode.parent.right == currentNode) {
			currentNode = currentNode.parent;
		}
		return currentNode.parent;
	}
	

	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(1);
		root.left = new BinaryTree(2, root);
		root.left.left = new BinaryTree(4, root.left);
		root.left.left.left = new BinaryTree(6, root.left.left);
		root.left.right = new BinaryTree(5, root.left);
		root.right = new BinaryTree(3, root);
		System.out.println(toString(root));

		System.out.println(findSuccessor(root, root.left.left).value);
		System.out.println(findSuccessor(root, root.left.left.left).value);
		System.out.println(findSuccessor(root, root.left.right).value);

	}
}
