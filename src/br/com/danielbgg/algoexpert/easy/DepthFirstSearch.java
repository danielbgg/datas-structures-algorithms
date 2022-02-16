package br.com.danielbgg.algoexpert.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DepthFirstSearch {

	static class Node {
		String name;
		List<Node> children = new ArrayList<Node>();

		public Node(String name) {
			this.name = name;
		}

		//time: O(n) | space: O(h)
		public List<String> depthFirstSearch(List<String> array) {
			// Write your code here.
			dps(this, array);
			return array;
		}
		
		private void dps(Node node, List<String> array) {
			if (node == null) {
				return;
			}
			array.add(node.name);
			if (node.children != null) {
				for (int i = 0; i < node.children.size(); i++) {
					dps(node.children.get(i), array);
				}
			}
		}

		public Node addChild(String name) {
			Node child = new Node(name);
			children.add(child);
			return this;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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

		System.out.println(Arrays.toString(a.depthFirstSearch(array).toArray()));

	}

}
