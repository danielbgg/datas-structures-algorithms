package br.com.danielbgg.algoexpert.medium;

public class BSTConstruction {

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}

		// average -> time: O(log n) | space: O(1)
		// worst -> time: O(n) | space: O(1)
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

		// average -> time: O(log n) | space: O(1)
		// worst -> time: O(n) | space: O(1)
		public boolean contains(int value) {
			BST root = this;
			while (root != null) {
				if (value < root.value) {
					root = root.left;
				} else if (value > root.value) {
					root = root.right;
				} else {
					return true;
				}
			}
			return false;
		}

		// average -> time: O(log n) | space: O(1)
		// worst -> time: O(n) | space: O(1)
		public BST remove(int value) {
			remove(value, null);
			return this;
		}

		public void remove(int value, BST parentNode) {
			// Write your code here.
			// Do not edit the return statement of this method.
			BST currentNode = this;

			while (currentNode != null) {

				if (value < currentNode.value) {
					parentNode = currentNode;
					currentNode = currentNode.left;
				} else if (value > currentNode.value) {
					parentNode = currentNode;
					currentNode = currentNode.right;
				} else {

					if (currentNode.left != null && currentNode.right != null) {
						// currentNode.value = smallest value of right subtree
						currentNode.value = currentNode.right.getMinValue();
						currentNode.right.remove(currentNode.value, currentNode);

					} else if (parentNode == null) {
						// root node
						if (currentNode.left != null) {
							currentNode.value = currentNode.left.value;
							currentNode.right = currentNode.left.right;
							currentNode.left = currentNode.left.left;
						} else if (currentNode.right != null) {
							currentNode.value = currentNode.right.value;
							currentNode.left = currentNode.right.left;
							currentNode.right = currentNode.right.right;
						} else {
							// single tree node - do nothing
						}

					} else if (parentNode.left == currentNode) {
						parentNode.left = currentNode.left != null ? currentNode.left : currentNode.right;
					} else if (parentNode.right == currentNode) {
						parentNode.right = currentNode.left != null ? currentNode.left : currentNode.right;
					}
					break;
				}
			}
		}

		private int getMinValue() {
			BST currentNode = this;
			while (currentNode.left != null) {
				currentNode = currentNode.left;
			}
			return currentNode.value;
		}

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

		root.remove(10);
		System.out.println(toString(root));

	}

}
