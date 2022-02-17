package br.com.danielbgg.algoexpert.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProductSum {

	public static int productSum(List<Object> array) {
		// Write your code here.
		return sum(array, 1, 0);
	}

	//time: O(n) | space: O(l)
	@SuppressWarnings("unchecked")
	private static int sum(List<Object> array, int level, int sum) {
		int levelSum = 0;
		for (int i = 0; i < array.size(); i++) {
			Object value = array.get(i);
			if (value instanceof ArrayList || value instanceof LinkedList) {
				levelSum = levelSum + sum((List<Object>)value, level + 1, 0);
			} else
			if (value instanceof Integer) {
				levelSum = levelSum + (Integer) value;
			}
		}
		sum = sum + (levelSum * level);
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Object> list = new LinkedList<Object>();

		List<Object> g1 = new LinkedList<Object>();
		g1.add(7);
		g1.add(-1);

		List<Object> g2 = new LinkedList<Object>();

		List<Object> g3 = new LinkedList<Object>();
		g3.add(-13);
		g3.add(8);

		g2.add(6);
		g2.add(g3);
		g2.add(4);

		list.add(5);
		list.add(2);
		list.add(g1);
		list.add(3);
		list.add(g2);

		System.out.println(productSum(list));
	}

}
