package br.com.danielbgg.datastructure.array;

public class ReverseString {
	
	public static String reverse(String s) {
		if (s != null) {
			char[] c = new char[s.length()];
			int begin = 0;
			for (int i = s.length() - 1; i >= 0; i--) {
				c[begin++] = s.charAt(i);
			}
			return new String(c);
		} else {
			return s;
		}
	}
	
	public static String reverseRecursive(String s) {
		if (s == null) return null;
		if (s.length() == 1) return "" + s.charAt(s.length() - 1);
		return "" + s.charAt(s.length() - 1) + reverseRecursive(s.substring(0, s.length() -1));
	}

	public static void main(String[] args) {
		System.out.println(reverse("Hi my name is Daniel"));
		System.out.println(reverseRecursive("Hi my name is Daniel"));
		System.out.println(reverse("X"));
		System.out.println(reverse(""));
		System.out.println(reverse(null));
	}

}
