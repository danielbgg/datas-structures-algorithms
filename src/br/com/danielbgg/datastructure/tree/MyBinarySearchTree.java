package br.com.danielbgg.datastructure.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MyBinarySearchTree {

	private Node root;

	private class Node {

		private Node left;
		private Node right;
		private Integer value;

		public Node(Integer value) {
			super();
			this.value = value;
		}

		public Integer getValue() {
			return value;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public String toString() {
			return value != null ? getValue().toString() : null;
		}
	}

	public MyBinarySearchTree() {
	}

	public boolean lookup(Integer value) {
		if (root == null) {
			return false;
		}
		return lookup(root, new Node(value)) != null;
	}

	private Node lookup(Node base, Node node) {
		if (base.getValue() == node.getValue()) {
			return node;
		}
		if (base.getValue() > node.getValue()) {
			if (base.getLeft() == null) {
				return null;
			} else {
				return lookup(base.getLeft(), node);
			}
		} else {
			if (base.getRight() == null) {
				return null;
			} else {
				return lookup(base.getRight(), node);
			}
		}
	}

	private Node lookupParent(Node parent, Node base, Node node) {
		if (base.getValue() == node.getValue()) {
			return parent;
		}
		if (base.getValue() > node.getValue()) {
			if (base.getLeft() == null) {
				return null;
			} else {
				return lookupParent(base, base.getLeft(), node);
			}
		} else {
			if (base.getRight() == null) {
				return null;
			} else {
				return lookupParent(base, base.getRight(), node);
			}
		}
	}

	private boolean isLeaf(Node node) {
		return (node.getLeft() == null && node.getRight() == null);
	}

	private boolean isSingleParent(Node node) {
		return (node.getLeft() == null && node.getRight() != null)
				|| (node.getLeft() != null && node.getRight() == null);
	}

	private Node returnSingleChild(Node node) {
		if (node.getLeft() == null && node.getRight() != null) {
			return node.getRight();
		} else if (node.getLeft() != null && node.getRight() == null) {
			return node.getLeft();
		} else {
			return null;
		}
	}

	public boolean remove(Integer value) {
		if (this.root == null) {
			return false;
		}
		Node currentNode = this.root;
		Node parentNode = null;
		while (currentNode != null) {
			if (value < currentNode.value) {
				parentNode = currentNode;
				currentNode = currentNode.left;
			} else if (value > currentNode.value) {
				parentNode = currentNode;
				currentNode = currentNode.right;
			} else if (currentNode.value == value) {
				// We have a match, get to work!

				// Option 1: No right child:
				if (currentNode.right == null) {
					if (parentNode == null) {
						this.root = currentNode.left;
					} else {

						// if parent > current value, make current left child a child of parent
						if (currentNode.value < parentNode.value) {
							parentNode.left = currentNode.left;

							// if parent < current value, make left child a right child of parent
						} else if (currentNode.value > parentNode.value) {
							parentNode.right = currentNode.left;
						}
					}

					// Option 2: Right child which doesnt have a left child
				} else if (currentNode.right.left == null) {
					currentNode.right.left = currentNode.left;
					if (parentNode == null) {
						this.root = currentNode.right;
					} else {

						// if parent > current, make right child of the left the parent
						if (currentNode.value < parentNode.value) {
							parentNode.left = currentNode.right;

							// if parent < current, make right child a right child of the parent
						} else if (currentNode.value > parentNode.value) {
							parentNode.right = currentNode.right;
						}
					}

					// Option 3: Right child that has a left child
				} else {

					// find the Right child's left most child
					Node leftmost = currentNode.right.left;
					Node leftmostParent = currentNode.right;
					while (leftmost.left != null) {
						leftmostParent = leftmost;
						leftmost = leftmost.left;
					}

					// Parent's left subtree is now leftmost's right subtree
					leftmostParent.left = leftmost.right;
					leftmost.left = currentNode.left;
					leftmost.right = currentNode.right;

					if (parentNode == null) {
						this.root = leftmost;
					} else {
						if (currentNode.value < parentNode.value) {
							parentNode.left = leftmost;
						} else if (currentNode.value > parentNode.value) {
							parentNode.right = leftmost;
						}
					}
				}
				return true;
			}
		}
		return false;
	}

	public void removeOLD(Integer value) {
		Node parent = lookupParent(root, root, new Node(value));
		Node node = (parent.getLeft() != null && parent.getLeft().value == value) ? parent.getLeft()
				: parent.getRight();

		if (isLeaf(node)) {
			if (parent.getLeft() != null && parent.getLeft().getValue() == value) {
				parent.setLeft(null);
			} else {
				parent.setRight(null);
			}
		} else if (isSingleParent(node)) {
			Node child = returnSingleChild(node);
			if (parent.getLeft() != null && parent.getLeft().getValue() == value) {
				parent.setLeft(child);
			} else {
				parent.setRight(child);
			}
		} else {
			// find successor
			Node right = node.getRight();
			if (right.getLeft() == null) {
				if (parent.getLeft() != null && parent.getLeft().getValue() == value) {
					parent.setLeft(right);
				} else {
					parent.setRight(right);
				}
				if (right.getValue() > node.getLeft().getValue()) {
					right.setLeft(node.getLeft());
				} else {
					right.setRight(node.getLeft());
				}
			} else {
			}
		}
	}

	public void insert(Integer value) {
		Node newNode = new Node(value);
		if (root == null) {
			root = newNode;
		} else {
			insertNode(root, newNode);
		}
	}

	private Node insertNode(Node base, Node newNode) {
		if (base.getValue() > newNode.getValue()) {
			if (base.getLeft() == null) {
				base.setLeft(newNode);
				return base;
			} else {
				return insertNode(base.getLeft(), newNode);
			}
		} else {
			if (base.getRight() == null) {
				base.setRight(newNode);
				return base;
			} else {
				return insertNode(base.getRight(), newNode);
			}
		}
	}

	public LinkedList<Node> depthFirstSearchInOrder() {
		return depthFirstSearchInOrder(root, new LinkedList<Node>());
	}

	private LinkedList<Node> depthFirstSearchInOrder(Node node, LinkedList<Node> list) {
		if (node.getLeft() != null) {
			depthFirstSearchInOrder(node.getLeft(), list);
		}
		list.add(node);
		if (node.getRight() != null) {
			depthFirstSearchInOrder(node.getRight(), list);
		}
		return list;
	}

	public LinkedList<Node> depthFirstSearchPreOrder() {
		return depthFirstSearchPreOrder(root, new LinkedList<Node>());
	}

	private LinkedList<Node> depthFirstSearchPreOrder(Node node, LinkedList<Node> list) {
		list.add(node);
		if (node.getLeft() != null) {
			depthFirstSearchPreOrder(node.getLeft(), list);
		}
		if (node.getRight() != null) {
			depthFirstSearchPreOrder(node.getRight(), list);
		}
		return list;
	}

	public LinkedList<Node> depthFirstSearchPostOrder() {
		return depthFirstSearchPostOrder(root, new LinkedList<Node>());
	}

	private LinkedList<Node> depthFirstSearchPostOrder(Node node, LinkedList<Node> list) {
		if (node.getLeft() != null) {
			depthFirstSearchPostOrder(node.getLeft(), list);
		}
		if (node.getRight() != null) {
			depthFirstSearchPostOrder(node.getRight(), list);
		}
		list.add(node);
		return list;
	}

	public LinkedList<Node> breadthFirstSearch() {
		Node currentNode = root;
		LinkedList<Node> list = new LinkedList<Node>();
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(currentNode);

		while (queue.size() > 0) {
			currentNode = queue.poll();
			list.add(currentNode);
			if (currentNode.getLeft() != null) {
				queue.add(currentNode.getLeft());
			}
			if (currentNode.getRight() != null) {
				queue.add(currentNode.getRight());
			}
		}

		return list;
	}

	public LinkedList<Node> breadthFirstSearchRecursive() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		return breadthFirstSearchRecursive(root, new LinkedList<Node>(), queue);
	}

	private LinkedList<Node> breadthFirstSearchRecursive(Node currentNode, LinkedList<Node> list, Queue<Node> queue) {
		if (queue.size() == 0) {
			return list;
		}
		currentNode = queue.poll();
		list.add(currentNode);
		if (currentNode.getLeft() != null) {
			queue.add(currentNode.getLeft());
		}
		if (currentNode.getRight() != null) {
			queue.add(currentNode.getRight());
		}
		return breadthFirstSearchRecursive(currentNode, list, queue);
	}

	private void print(LinkedList<Node> list) {
		for (Iterator<Node> iterator = list.iterator(); iterator.hasNext();) {
			Node node = (Node) iterator.next();
			System.out.print(node.getValue() + " ");
		}
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder(50);
		print(root, buffer, "", "");
		return buffer.toString();
	}

	private void print(Node n, StringBuilder buffer, String prefix, String childrenPrefix) {
		buffer.append(prefix);
		buffer.append(n.getValue());
		buffer.append('\n');

		if (n.getLeft() != null) {
			print(n.getLeft(), buffer, childrenPrefix + "--- ", childrenPrefix + "|   ");
		}
		if (n.getRight() != null) {
			print(n.getRight(), buffer, childrenPrefix + "+++ ", childrenPrefix + "|   ");
		}

	}

	public boolean validateBST() {
		Node currentNode = root;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(currentNode);

		while (queue.size() > 0) {
			currentNode = queue.poll();
			if (currentNode.getLeft() != null) {
				if (currentNode.getValue() < currentNode.getLeft().getValue()) {
					return false;
				}
				queue.add(currentNode.getLeft());
			}
			if (currentNode.getRight() != null) {
				if (currentNode.getValue() > currentNode.getRight().getValue()) {
					return false;
				}
				queue.add(currentNode.getRight());
			}
		}
		return true;
	}

	public static void main(String[] args) {
//		MyBinarySearchTree mine = new MyBinarySearchTree();
//		mine.insert(61);
//		mine.insert(89);
//		mine.insert(47);
//		mine.insert(96);
//		mine.insert(100);
//		mine.insert(40);
//		mine.insert(52);
//		mine.insert(42);
//		mine.insert(45);
//		mine.insert(15);
//		mine.insert(14);
//		mine.insert(16);
//		mine.insert(43);
//		mine.insert(44);
//		System.out.println(mine);
//		System.out.println(mine.lookup(61));
//		System.out.println(mine.lookup(62));
//		System.out.println(mine.lookup(15));
//		System.out.println(mine.lookup(100));
//		mine.remove(14);
//		mine.remove(16);
//		mine.remove(96);
//		mine.remove(47);
//		mine.remove(40);
//		mine.remove(42);
//		System.out.println(mine);

		MyBinarySearchTree mine2 = new MyBinarySearchTree();
		mine2.insert(9);
		mine2.insert(4);
		mine2.insert(6);
		mine2.insert(20);
		mine2.insert(170);
		mine2.insert(15);
		mine2.insert(1);
		System.out.println(mine2);
		System.out.println(mine2.validateBST());
		

		System.out.println("BFS:");
		mine2.print(mine2.breadthFirstSearch());
		System.out.println();
		mine2.print(mine2.breadthFirstSearchRecursive());
		System.out.println();

		System.out.println("DFS In Order:");
		mine2.print(mine2.depthFirstSearchInOrder());
		System.out.println();

		System.out.println("DFS Pre Order:");
		mine2.print(mine2.depthFirstSearchPreOrder());
		System.out.println();

		System.out.println("DFS Post Order:");
		mine2.print(mine2.depthFirstSearchPostOrder());
		System.out.println();

	}

}
