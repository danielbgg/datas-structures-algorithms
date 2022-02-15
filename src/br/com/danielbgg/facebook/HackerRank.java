package br.com.danielbgg.facebook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HackerRank {

	/*
	 * Complete the 'designerPdfViewer' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER_ARRAY h 2. STRING word
	 */
	public static int designerPdfViewer(List<Integer> h, String word) {
		// Write your code here
		int max = 0;
		for (int i = 0; i < word.length(); i++) {
			int index = Character.getNumericValue(word.charAt(i)) - 10;
			int value = h.get(index);
			if (value > max) {
				max = value;
			}
		}
		return max * word.length();
	}

	/*
	 * Complete the 'rotLeft' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER_ARRAY a 2. INTEGER d
	 */
	public static List<Integer> rotLeft(List<Integer> a, int d) {
		// Write your code here
		for (int i = 0; i < d; i++) {
			Integer value = a.remove(0);
			a.add(value);
		}
		return a;
	}

	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}

			this.tail = node;
		}
	}

	/*
	 * Complete the 'insertNodeAtPosition' function below.
	 *
	 * The function is expected to return an INTEGER_SINGLY_LINKED_LIST. The
	 * function accepts following parameters: 1. INTEGER_SINGLY_LINKED_LIST llist 2.
	 * INTEGER data 3. INTEGER position
	 */
	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode { int data; SinglyLinkedListNode next; }
	 *
	 */

	public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
		// Write your code here
		if (position == 0) {
			return new SinglyLinkedListNode(data);
		}

		SinglyLinkedListNode node = llist;
		int counter = 0;

		while (true) {
			if (counter == data) {
				SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
				newNode.next = node.next;
				node.next = newNode;
				break;
			} else {
				counter++;
			}
		}

		return llist;
	}

	static boolean hasCycle(SinglyLinkedListNode head) {
		if (head == null)
			return false;

		SinglyLinkedListNode slow = head;
		SinglyLinkedListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}

		return false;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
