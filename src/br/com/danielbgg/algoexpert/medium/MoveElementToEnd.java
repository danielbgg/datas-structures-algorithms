package br.com.danielbgg.algoexpert.medium;

import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {

	//time: O(n) | space: O(1)
	public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
		int index=0;
		int counter=0;
		int set = 0;
		
		while (index<array.size()) {
			int num = array.get(index);
			if (num == toMove) {
				counter++;
			} else {
				array.set(index-counter, num);
				set++;
			}
			index++;
		}

		for (int i = set; i<array.size(); i++) {
			array.set(i, toMove);
		}
		
		return array;
	}

	public static void main(String[] args) {
		List<Integer> result = moveElementToEnd(Arrays.asList(new Integer[] { 2, 1, 2, 2, 2, 3, 4, 2 }), 2);
		System.out.println(Arrays.toString(result.toArray()));
	}

}
