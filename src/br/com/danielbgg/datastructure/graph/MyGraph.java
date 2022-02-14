package br.com.danielbgg.datastructure.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class MyGraph {
	
	private Map<Integer, LinkedList<Integer>> adjacentList;
	private int numberOfNodes;
	
	public MyGraph() {
		numberOfNodes = 0;
		adjacentList = new HashMap<Integer, LinkedList<Integer>>();
	}
	
	private boolean exists(Integer node) {
		return adjacentList.get(node) != null;
	}
	
	public void addVertex(Integer node) {
		if (!exists(node)) {
			adjacentList.put(node, new LinkedList<Integer>());
			numberOfNodes++;
		}
	}
	
	public void addEdge(Integer node1, Integer node2) {
		if (exists(node1) && exists(node2)) {
			adjacentList.get(node1).push(node2);
			adjacentList.get(node2).push(node1);
		}
	}
	
	public void showConnections() {
		StringBuffer buff = new StringBuffer("Graph has ").append(numberOfNodes).append(" nodes\n");
		Set<Integer> keys = adjacentList.keySet();
		for (Iterator<Integer> iterator = keys.iterator(); iterator.hasNext();) {
			Integer key = iterator.next();
			buff.append(key).append(" --> ");
			LinkedList<Integer> ll = adjacentList.get(key);
			for (Iterator<Integer> iterator2 = ll.iterator(); iterator2.hasNext();) {
				Integer value = (Integer) iterator2.next();
				buff.append(value).append(" ");
			}
			buff.append("\n");
		}
		System.out.println(buff);
	}
	
	public static void main(String[] args) {
		MyGraph mine = new MyGraph();
		mine.addVertex(0);
		mine.addVertex(1);
		mine.addVertex(2);
		mine.addVertex(3);
		mine.addVertex(4);
		mine.addVertex(5);
		mine.addVertex(6);

		mine.addEdge(3, 1);
		mine.addEdge(3, 4);
		mine.addEdge(4, 2);
		mine.addEdge(4, 5);
		mine.addEdge(1, 2);
		mine.addEdge(1, 0);
		mine.addEdge(0, 2);
		mine.addEdge(6, 5);
		
		mine.showConnections();
		
	}
	
	

}
