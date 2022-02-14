package br.com.danielbgg.datastructure.queue;

public class MyQueue {

	private Node first;
	private Node last;

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

	public MyQueue() {
	}

	public Object peek() {
		if (first == null) {
			return null;
		}
		return first.getValue();
	}

	public void enqueue(Object value) {
		Node newNode = new Node(value);
		if (isEmpty()) {
			first = newNode;
			last = newNode;
		} else {
			last.setNext(newNode);
		}
		last = newNode;
		length++;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public Object dequeue() {
		if (isEmpty()) {
			return null;
		}
		Object result = first.getValue();
		first = first.getNext();
		length--;
		if (isEmpty()) {
			first = null;
			last = null;
		}
		return result;
	}

	public String toString() {
		StringBuffer buff = new StringBuffer("Queue (l: ").append(length);
		buff.append(" - f: ").append(first);
		buff.append(" - l: ").append(last).append(")  first -> ");
		Node n = first;
		while (n != null) {
			buff.append(n.getValue() + " -> ");
			n = n.getNext();
		}
		return buff.append("last").toString();
	}

	public static void main(String[] args) {
		MyQueue mine = new MyQueue();
		System.out.println(mine.peek());
		mine.enqueue(1);
		System.out.println(mine.peek());
		mine.enqueue(2);
		mine.enqueue(3);
		System.out.println(mine);
		
		System.out.println(mine.dequeue());
		System.out.println(mine.dequeue());
		System.out.println(mine.dequeue());
		System.out.println(mine);

		
		for (int i = 10; i < 30; i++) {
			mine.enqueue("Objeto: " + i);
		}
		System.out.println(mine);
		
		Object node = null;
		do {
			node = mine.dequeue();
			System.out.println(node);
		} while (node != null);
		System.out.println(mine);
	}

}
