package br.com.danielbgg.algoexpert.easy;

public class CaesarCipherEncryptor {

	//time: O(n) | space: O(n)
	public static String caesarCypherEncryptor(String str, int key) {
		// Write your code here.
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			int letter = str.charAt(i);
			int newValue = letter + (key % 26);
			if (newValue > 122) {
				newValue = newValue - 26;
			}
			buffer.append(Character.toString((char) newValue));
		}
		return buffer.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(caesarCypherEncryptor("az", 1));
		// System.out.println(caesarCypherEncryptor("aaa", 1));
	}

}
