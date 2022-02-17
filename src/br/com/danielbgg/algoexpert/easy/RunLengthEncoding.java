package br.com.danielbgg.algoexpert.easy;

public class RunLengthEncoding {

	//time: O(n) | space: O(n)
	public static String runLengthEncoding(String string) {
		// Write your code here.
		StringBuffer buffer = new StringBuffer();
		char currentChar = string.charAt(0);
		int repeats = 0;

		for (int i = 0; i < string.length(); i++) {
			char newChar = string.charAt(i);

			if (newChar == currentChar) {
				repeats++;
			} else {
				buffer.append(storeChar(currentChar, repeats));
				repeats = 1;
			}
			currentChar = newChar;
		}
		buffer.append(storeChar(currentChar, repeats));
		return buffer.toString();
	}

	private static String storeChar(char c, int repeats) {
		StringBuffer buffer = new StringBuffer();
		if (repeats < 10) {
			return buffer.append(repeats).append(c).toString();
		} else {
			int qty = repeats / 9;
			for (int i = 0; i < qty; i++) {
				buffer.append("9").append(c);
			}
			return buffer.append(repeats % 9).append(c).toString();
		}
	}

	public static void main(String[] args) {
		System.out.println(runLengthEncoding("AAACCCBD"));
		System.out.println(runLengthEncoding("AAAAAAAAAAAAABBCCCCDD"));
	}

}
