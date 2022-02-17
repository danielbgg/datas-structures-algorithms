package br.com.danielbgg.algoexpert.easy;

import java.util.HashMap;

public class GenerateDocument {

	//time: O(n + m) | space: O(c) c=unique characters
	public static boolean generateDocument(String characters, String document) {
		// Write your code here.
		if (document == "") return true; 
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < characters.length(); i++) {
			Character c = characters.charAt(i);
			if (map.get(c) == null) {
				map.put(c, 1);
			} else {
				int quantity = map.get(c);
				map.replace(c, ++quantity);
			}
		}
		
		for (int i = 0; i < document.length(); i++) {
			Character c = document.charAt(i);
			if (map.get(c) == null) {
				return false;
			} else {
				int quantity = map.get(c);
				if (quantity <= 0) {
					return false;
				}
				map.replace(c, --quantity);
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		System.out.println(generateDocument("Daniel", "Daniel"));
		System.out.println(generateDocument("Bste!hetsi ogEAxpelrt x ", "AlgoExpert is the Best!"));
	}

}
