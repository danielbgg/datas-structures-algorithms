package br.com.danielbgg.algoexpert.easy;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

	//time: O(n), space: O(1) [only 26 characters]
	public static int firstNonRepeatingCharacter(String string) {
		Map<Character, Integer> cache = new HashMap<Character, Integer>();
		for (int i = 0; i < string.length(); i++) {
			Character comparison = string.charAt(i);
			Integer value = cache.get(comparison);
			if (value == null) {
				cache.put(comparison, 0);
			} else {
				cache.replace(comparison, ++value);
			}
		}
		
		for (int i = 0; i < string.length(); i++) {
			Character comparison = string.charAt(i);
			Integer value = cache.get(comparison);
			if (value == null || value == 0) {
				return i;
			}
		}
		return -1;
	}
	
	
	//time: O(n^2), space: O(1)
	public static int firstNonRepeatingCharacterLoop(String string) {
		// Write your code here.
		for (int i = 0; i < string.length(); i++) {
			Character comparison = string.charAt(i);
			boolean found = false;
			for (int j = 0; j < string.length(); j++) {
				if (i == j) continue;
				if (comparison.equals(string.charAt(j))) {
					found = true;
					break;
				}
			}
			if (!found) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(firstNonRepeatingCharacterLoop("abcdcaf"));
		System.out.println(firstNonRepeatingCharacterLoop("faadabcbbebdf"));
		
		System.out.println(firstNonRepeatingCharacter("abcdcaf"));
		System.out.println(firstNonRepeatingCharacter("faadabcbbebdf"));
		

	}

}
