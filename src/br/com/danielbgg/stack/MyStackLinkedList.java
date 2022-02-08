package br.com.danielbgg.stack;

public class MyStackLinkedList {

	private Node bottom;
	private Node top;

	private int length;

	private class Node {

		private Node next;
		private Object value;

		public Node(Object value) {
			super();
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Object getValue() {
			return value;
		}

		public String toString() {
			return value != null ? getValue().toString() : null;
		}
	}

	public MyStackLinkedList() {
	}

	public Object peek() {
		return top.getValue();
	}

	public void push(Object value) {
		Node newNode = new Node(value);
		newNode.setNext(top);
		top = newNode;
		if (bottom == null) {
			bottom = top;
		}
		length++;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public Object pop() {
		if (isEmpty()) {
			bottom = null;
			return null;
		}
		Object result = top.getValue();
		top = top.getNext();
		length--;
		return result;
	}

	public String toString() {
		StringBuffer buff = new StringBuffer("Stack (l: ").append(length);
		buff.append(" - b: ").append(bottom);
		buff.append(" - t: ").append(top).append(")  top -> ");
		Node n = top;
		while (n != null) {
			buff.append(n.getValue() + " -> ");
			n = n.getNext();
		}
		return buff.append("bottom").toString();
	}

	public static void main(String[] args) {
		MyStackLinkedList mine = new MyStackLinkedList();
		for (int i = 10; i < 30; i++) {
			mine.push("Objeto: " + i);
		}
		System.out.println(mine);
		
		Object node = null;
		do {
			node = mine.pop();
			System.out.println(node);
		} while (node != null);
		System.out.println(mine);
	}

}
