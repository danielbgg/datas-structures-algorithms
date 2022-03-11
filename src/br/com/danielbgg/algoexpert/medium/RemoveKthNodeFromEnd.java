package br.com.danielbgg.algoexpert.medium;

public class RemoveKthNodeFromEnd {

	//time: O(n) | space: O(1)
	public static void removeKthNodeFromEnd(LinkedList head, int k) {
		int pointer = 0;

		LinkedList advancedNode = head;
		LinkedList node = head;

		for (int i = 0; i < k; i++) {
			advancedNode = advancedNode.next;
		}

		while (advancedNode != null) {
			pointer++;
			advancedNode = advancedNode.next;
			if (advancedNode != null) {
				node = node.next;
			}
		}

		if (pointer == 0) {
			head.value = node.next.value;
			head.next = node.next.next;
		} else {
			node.next = node.next.next;
		}

	}

	static class LinkedList {
		int value;
		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList(0);
		LinkedList node = ll;
		for (int i = 1; i < 10; i++) {
			node.next = new LinkedList(i);
			node = node.next;
		}
		removeKthNodeFromEnd(ll, 10);

		node = ll;
		while (node != null) {
			System.out.println(node.value);
			node = node.next;
		}
	}

}
