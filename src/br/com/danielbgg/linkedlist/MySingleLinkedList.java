package br.com.danielbgg.linkedlist;

public class MySingleLinkedList {

	private Node head;
	private Node tail;
	private int length;

	private class Node {

		private Node next;
		private Object value;

		public Node(Object value) {
			super();
			this.value = value;
		}

		public Node(Object value, Node next) {
			super();
			this.next = next;
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

		public void setValue(Object value) {
			this.value = value;
		}

		public String toString() {
			return value != null ? getValue().toString() : null;
		}

	}

	public MySingleLinkedList(Object value) {
		this.head = new Node(value);
		this.tail = this.head;
		length++;
	}

	public void append(Object value) {
		Node newNode = new Node(value);
		tail.setNext(newNode);
		tail = newNode;
		length++;
	}

	public void prepend(Object value) {
		Node newNode = new Node(value);
		newNode.setNext(head);
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
		leader.setNext(newNode);
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
			head.setNext(null);
			head = nextNode;
			length--;
		} else {
			Node leader = traverseToIndex(index);
			Node toDelete = leader.getNext();
			Node nextNode = toDelete.getNext();
			leader.setNext(nextNode);
			length--;
		}
		System.out.println(this);
	}

	public String toString() {
		StringBuffer buff = new StringBuffer("LL (l: ").append(length);
		buff.append(" - h: ").append(head);
		buff.append(" - t: ").append(tail).append(")  ");
		Node n = head;
		while (n != null) {
			buff.append(n.getValue() + " -> ");
			n = n.getNext();
		}
		return buff.append("null").toString();
	}

	public void reverse() {
		if (length <= 1) {
			return;
		}

		Node first = head;
		tail = first;
		Node second = first.getNext();

		while (second != null) {
			Node third = second.getNext();
			second.setNext(first);
			first = second;
			second = third;
		}

		tail.setNext(null);
		head = first;
		System.out.println(this);
	}

	public static void main(String[] args) {
		MySingleLinkedList mine = new MySingleLinkedList(10);
		mine.append(11);
		mine.append(12);
		mine.append(13);
		mine.append(14);
		mine.append(15);
		mine.prepend(9);
		mine.prepend(8);
		mine.prepend(7);
		mine.prepend(6);
		System.out.println(mine);

		mine.insert(4, 99);
		mine.insert(2, 77);
		mine.insert(1, 66);
		mine.insert(0, 5);
		mine.insert(14, 16);

		mine.remove(2);
		mine.remove(13);
		mine.remove(0);

		mine.reverse();
	}

}
