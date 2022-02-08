package br.com.danielbgg.linkedlist;

public class MyDoubleLinkedList {

	private Node head;
	private Node tail;
	private int length;

	private class Node {

		private Node next;
		private Node previous;
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

		public Node getPrevious() {
			return previous;
		}

		public void setPrevious(Node previous) {
			this.previous = previous;
		}

		public String toString() {
			return value != null ? getValue().toString() : null;
		}

	}

	public MyDoubleLinkedList(Object value) {
		this.head = new Node(value);
		this.tail = this.head;
		length++;
	}

	public void append(Object value) {
		Node newNode = new Node(value);
		newNode.setPrevious(tail);
		tail.setNext(newNode);
		tail = newNode;
		length++;
	}

	public void prepend(Object value) {
		Node newNode = new Node(value);
		newNode.setNext(head);
		head.setPrevious(newNode);
		head = newNode;
		length++;
	}

	public void insert(int index, Object value) {
		if (index == 0) {
			prepend(value);
			System.out.println(this);
			return;
		}
		if (index >= length) {
			append(value);
			System.out.println(this);
			return;
		}

		Node leader = traverseToIndex(index);

		Node newNode = new Node(value);
		newNode.setNext(leader.getNext());
		newNode.setPrevious(leader);
		leader.setNext(newNode);
		newNode.getNext().setPrevious(newNode);
		length++;

		System.out.println(this);
	}

	private Node traverseToIndex(int index) {
		int counter = 0;
		Node node = head;
		while (node != null) {
			counter++;
			if (counter == index) {
				return node;
			}
			node = node.getNext();
		}
		return null;
	}

	public void remove(int index) {
		if (index >= length || length == 1) {
			throw new NullPointerException("Invalid index!");
		}

		if (index == 0) {
			Node nextNode = head.getNext();
			head = nextNode;
			head.setPrevious(null);
			length--;
		} else {
			Node leader = traverseToIndex(index);
			Node toDelete = leader.getNext();
			Node nextNode = toDelete.getNext();
			leader.setNext(nextNode);
			if (nextNode == null) {
				tail = leader;
			} else {
				nextNode.setPrevious(leader);
			}
			length--;
		}
		System.out.println(this);
	}

	public String toString() {
		StringBuffer buff = new StringBuffer("LL (l: ").append(length);
		buff.append(" - h: ").append(head);
		buff.append(" - t: ").append(tail).append(") \n     head -> ");
		
		Node n = head;
		while (n != null) {
			buff.append(n.getValue() + " -> ");
			n = n.getNext();
		}
		buff.append("tail \n     tail -> ");
		

		n = tail;
		while (n != null) {
			buff.append(n + " -> ");
			n = n.getPrevious();
		}
		return buff.append("head").toString();
	}
	
	public static void main(String[] args) {
		MyDoubleLinkedList mine = new MyDoubleLinkedList(10);
		mine.append(11);
		mine.append(12);
		mine.prepend(9);
		mine.prepend(8);
		System.out.println(mine);

		mine.insert(4, 110);
		mine.insert(2, 90);
		mine.insert(1, 80);
		mine.insert(0, 7);
		mine.insert(9, 13);

		mine.remove(2);
		mine.remove(8);
		mine.remove(0);
	}

}
