package br.com.danielbgg.algoexpert.medium;

public class SingleCycleCheck {

	//time: O(n) | space: O(1)
	public static boolean hasSingleCycle(int[] array) {
		int visited = 0;
		int currentIdx = 0;
		while (visited < array.length) {
			if (visited > 0 && currentIdx == 0)
				return false;
			visited++;
			currentIdx = getNextIndex(currentIdx, array);
		}
		return currentIdx == 0;
	}

	private static int getNextIndex(int currentIdx, int[] array) {
		int jump = array[currentIdx];
		int nextIdx = (currentIdx + jump) % array.length;
		return nextIdx >= 0 ? nextIdx : nextIdx + array.length;
	}

	public static void main(String[] args) {
		// System.out.println(hasSingleCycle(new int[] { 2, 3, 1, -4, -4, 2 }));
		System.out.println(hasSingleCycle(new int[] { 1, 1, 1, 1, 2 }));
	}

}
