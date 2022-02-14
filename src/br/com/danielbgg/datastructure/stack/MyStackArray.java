package br.com.danielbgg.datastructure.stack;

import java.util.Arrays;

public class MyStackArray {

	private int cursor;
	private Object[] data;

	public MyStackArray(int size) {
		data = new Object[size];
	}

	public Object peek() {
		return data[cursor == 0 ? cursor : cursor - 1];
	}

	public void push(Object value) {
		if (cursor == data.length) {
			data = Arrays.copyOf(data, cursor * 2);
		}
		data[cursor] = value;
		cursor++;
	}

	public boolean isEmpty() {
		return cursor == 0;
	}

	public Object pop() {
		if (isEmpty()) {
			return null;
		}
		Object result = data[cursor - 1];
		data[cursor - 1] = null;
		cursor--;
		return result;
	}

	public String toString() {
		StringBuffer buff = new StringBuffer("Stack (l: ").append(cursor);
		buff.append(" - b: ").append(data[0]);
		buff.append(" - t: ").append(data[cursor]).append(")  top -> ");

		for (int i = cursor - 1; i >= 0; i--) {
			buff.append(data[i] + " -> ");
		}

		return buff.append("bottom").toString();
	}

	public static void main(String[] args) {
		MyStackArray mine = new MyStackArray(2);
		System.out.println(mine.peek());
		mine.push(1);
		System.out.println(mine.peek());
		mine.push(2);
		System.out.println(mine.peek());
		mine.push(3);
		System.out.println(mine.peek());

		System.out.println(mine);
		

		System.out.println(mine.pop());
		System.out.println(mine.pop());
		System.out.println(mine.pop());
		System.out.println(mine.pop());
		System.out.println(mine);

		for (int i = 1; i < 11; i++) {
			mine.push("OBJ " + i);
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
