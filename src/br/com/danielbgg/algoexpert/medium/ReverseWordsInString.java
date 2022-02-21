package br.com.danielbgg.algoexpert.medium;

public class ReverseWordsInString {

	public static String reverseWordsInString(String string) {
		char[] characters = string.toCharArray();
		reverseListRange(characters, 0, characters.length - 1);
		int startOfWord = 0;
		while (startOfWord < characters.length) {
			int endOfWord = startOfWord;
			while (endOfWord < characters.length && characters[endOfWord] != ' ') {
				endOfWord++;
			}
			reverseListRange(characters, startOfWord, endOfWord - 1);
			startOfWord = endOfWord + 1;
		}
		return new String(characters);
	}

	private static char[] reverseListRange(char[] list, int start, int end) {
		while (start < end) {
			char temp = list[start];
			list[start] = list[end];
			list[end] = temp;
			start++;
			end--;
		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println(reverseWordsInString("AlgoExpert is the best!"));
	}

}
