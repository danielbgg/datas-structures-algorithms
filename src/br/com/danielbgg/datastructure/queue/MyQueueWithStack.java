package br.com.danielbgg.datastructure.queue;

import br.com.danielbgg.datastructure.stack.MyStackLinkedList;

public class MyQueueWithStack {

	private MyStackLinkedList stackPush;
	private MyStackLinkedList stackPop;

	public MyQueueWithStack() {
		stackPush = new MyStackLinkedList();
		stackPop = new MyStackLinkedList();
	}

	public Object peek() {
		fillStackPop();
		return stackPop.peek();
	}

	public void enqueue(Object value) {
		fillStackPush();
		stackPush.push(value);
	}

	public boolean isEmpty() {
		fillStackPop();
		return stackPop.isEmpty();
	}

	public Object dequeue() {
		fillStackPop();
		return stackPop.pop();
	}

	private void fillStackPush() {
		if (stackPush.isEmpty() && !stackPop.isEmpty()) {
			while (!stackPop.isEmpty()) {
				stackPush.push(stackPop.pop());
			}
		}
	}

	private void fillStackPop() {
		if (!stackPush.isEmpty() && stackPop.isEmpty()) {
			while (!stackPush.isEmpty()) {
				stackPop.push(stackPush.pop());
			}
		}
	}

	public String toString() {
		fillStackPop();
		return stackPop.toString();
	}

	public static void main(String[] args) {
		MyQueueWithStack mine = new MyQueueWithStack();
		mine.enqueue(1);
		mine.enqueue(2);
		mine.enqueue(3);
		System.out.println(mine);

		System.out.println(mine.peek());
		System.out.println(mine.dequeue());
		System.out.println(mine.peek());
		System.out.println(mine.dequeue());
		System.out.println(mine.peek());
		System.out.println(mine.dequeue());
		System.out.println(mine);
	}

}
