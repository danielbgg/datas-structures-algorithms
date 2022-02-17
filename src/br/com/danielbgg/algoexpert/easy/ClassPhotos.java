package br.com.danielbgg.algoexpert.easy;

import java.util.ArrayList;
import java.util.Collections;

public class ClassPhotos {

	//time: O(n log n) | space: O(1)
	public static boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
		// Write your code here.
		Collections.sort(redShirtHeights);
		Collections.sort(blueShirtHeights);
		if (redShirtHeights.get(0) > blueShirtHeights.get(0)) {
			return checkHeights(redShirtHeights, blueShirtHeights);
		} else {
			return checkHeights(blueShirtHeights, redShirtHeights);
		}
	}
	
	private static boolean checkHeights(ArrayList<Integer> group1, ArrayList<Integer> group2) {
		for (int i = 0; i < group1.size(); i++) {
			Integer g1 = group1.get(i);
			Integer g2 = group2.get(i);
			if (g2 >= g1) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ArrayList<Integer> redShirtHeights = new ArrayList<Integer>();
		redShirtHeights.add(5);
		redShirtHeights.add(8);
		redShirtHeights.add(1);
		redShirtHeights.add(3);
		redShirtHeights.add(4);
		ArrayList<Integer> blueShirtHeights = new ArrayList<Integer>();
		blueShirtHeights.add(6);
		blueShirtHeights.add(9);
		blueShirtHeights.add(2);
		blueShirtHeights.add(4);
		blueShirtHeights.add(5);
		System.out.println(classPhotos(redShirtHeights, blueShirtHeights));
	}

}
