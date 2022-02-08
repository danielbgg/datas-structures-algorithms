package br.com.danielbgg.array;

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

	public static void main(String[] args) {
		System.out.println(reverse("Hi my name is Daniel"));
		System.out.println(reverse("X"));
		System.out.println(reverse(""));
		System.out.println(reverse(null));
	}

}
