package br.com.danielbgg.array;

import java.util.Arrays;

public class MyArray {

	int capacity;
	int length;
	Object[] data;

	public MyArray() {
		capacity = 10;
		this.length = 0;
		this.data = new Object[capacity];
	}

	public Object get(int index) {
		return this.data[index];
	}

	public int push(Object item) {
		if (capacity == length) {
			data = Arrays.copyOf(data, capacity * 2);
			capacity *= 2;
		}
		data[length] = item;
		length++;
		return this.length;
	}

	public Object pop() {
		Object lastItem = data[this.length - 1];
		data[this.length - 1] = null;
		this.length--;
		return lastItem;
	}

	public Object delete(int index) {
		Object item = this.data[index];
		this.shiftItems(index);
		return item;
	}

	private void shiftItems(int index) {
		for (int i = index; i < this.length; i++) {
			this.data[i] = this.data[i + 1];
		}
		this.data[length - 1] = null;
		this.length--;
	}

	public void print() {
		Arrays.asList(data).stream().filter(i -> i != null).forEach(i -> System.out.print(i + " "));
		System.out.println("");
	}

	public static void main(String[] args) {
		MyArray mine = new MyArray();
		mine.push("objeto 1");
		mine.push("objeto 2");
		mine.push("objeto 3");
		mine.push("objeto 4");
		mine.push("objeto 5");
		mine.push("objeto 6");
		mine.print();
		System.out.println(mine.pop());
		mine.print();
		System.out.println(mine.delete(2));
		mine.print();
	}

}
