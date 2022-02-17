package br.com.danielbgg.algoexpert.easy;

public class RemoveDuplicatesFromLinkedList {

	public static class LinkedList {
		public int value;
		public LinkedList next;

		public LinkedList(int value) {
			this.value = value;
			this.next = null;
		}
	}

	//time: O(n) | space: O(1)
	public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
		// Write your code here.

		LinkedList parent = linkedList;
		LinkedList node = linkedList;

		int lastNum = Integer.MIN_VALUE;
		
		while (node != null) {
			if (lastNum == node.value) {
				//remove
				parent.next = node.next;
			} else {
				parent = node;
			}
			lastNum = node.value; 
			node = node.next;
		}
		return linkedList;
	}

	public static String print(LinkedList root) {
		StringBuffer buff = new StringBuffer();
		LinkedList n = root;
		while (n != null) {
			buff.append(n.value + " -> ");
			n = n.next;
		}
		return buff.append("null").toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList root = new LinkedList(1);
		root.next = new LinkedList(1);
		root.next.next = new LinkedList(3);
		root.next.next.next = new LinkedList(4);
		root.next.next.next.next = new LinkedList(4);
		root.next.next.next.next.next = new LinkedList(4);
		root.next.next.next.next.next.next = new LinkedList(5);
		root.next.next.next.next.next.next.next = new LinkedList(6);
		root.next.next.next.next.next.next.next.next = new LinkedList(6);
		System.out.println(print(removeDuplicatesFromLinkedList(root)));
	}

}
