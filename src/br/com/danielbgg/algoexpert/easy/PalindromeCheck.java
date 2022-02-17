package br.com.danielbgg.algoexpert.easy;

public class PalindromeCheck {

	//time: O(n) | space: O(1)
	public static boolean isPalindrome(String str) {
		// Write your code here.
		for (int i = 0; i < str.length(); i++) {
			char beginChar = str.charAt(i);
			char finalChar = str.charAt(str.length()-1-i);
			if (beginChar != finalChar) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("ab"));
		System.out.println(isPalindrome("aa"));
		System.out.println(isPalindrome(""));
		System.out.println(isPalindrome("abcdcba"));
		System.out.println(isPalindrome("abcddcba"));
		System.out.println(isPalindrome("daniel"));
	}

}
