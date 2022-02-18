package br.com.danielbgg.algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

	static class Node {
		String name;
		List<Node> children = new ArrayList<Node>();

		public Node(String name) {
			this.name = name;
		}

		public Node addChild(String name) {
			Node child = new Node(name);
			children.add(child);
			return this;
		}

		//time: O(n) | space: O(n);
		public List<String> breadthFirstSearch(List<String> array) {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(this);

			while (!queue.isEmpty()) {
				Node node = queue.poll();
				array.add(node.name);
				if (node.children != null) {
					for (int i = 0; i < node.children.size(); i++) {
						queue.add(node.children.get(i));
					}
				}
			}

			return array;
		}

	}

	public static void main(String[] args) {

		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		Node f = new Node("F");
		Node g = new Node("G");
		Node h = new Node("H");
		Node i = new Node("I");
		Node j = new Node("J");
		Node k = new Node("K");

		a.children.add(b);
		a.children.add(c);
		a.children.add(d);

		b.children.add(e);
		b.children.add(f);

		f.children.add(i);
		f.children.add(j);

		d.children.add(g);
		d.children.add(h);

		g.children.add(k);

		List<String> array = new LinkedList<String>();

		System.out.println(Arrays.toString(a.breadthFirstSearch(array).toArray()));
	}

}
