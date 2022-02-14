package br.com.danielbgg.datastructure.question;

import java.util.HashMap;
import java.util.Map;

public class GoogleFirstRecurringCharacter {

	public static Integer checkRecurring(int[] values) {
		Map<Integer, Boolean> numbers = new HashMap<Integer, Boolean>();
		if (values == null) {
			return null;
		}
		for (int i = 0; i < values.length; i++) {
			int num = values[i];
			Boolean isInMap = numbers.get(num);
			if (isInMap != null) {
				return num;
			} else {
				numbers.put(num, true);
			}
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(GoogleFirstRecurringCharacter.checkRecurring(new int[] { 2, 5, 1, 2, 3, 5, 1, 2, 4 }));
		System.out.println(GoogleFirstRecurringCharacter.checkRecurring(new int[] { 2, 1, 1, 2, 3, 5, 1, 2, 4 }));
		System.out.println(GoogleFirstRecurringCharacter.checkRecurring(new int[] { 2, 3, 4, 5 }));
	}

}
