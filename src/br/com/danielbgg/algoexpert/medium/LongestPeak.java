package br.com.danielbgg.algoexpert.medium;

public class LongestPeak {

	//time: O(n) | space: O(1)
	public static int longestPeak(int[] array) {
		if (array == null || array.length < 3) {
			return 0;
		}
		
		int counter = 1;
		int greatestPeak = 0;

		while (counter < array.length -1) {
			int previous = array[counter-1];
			int value = array[counter];
			int next = array[counter+1];
			
			if (value > previous && value > next) {
				//peak
				int peakCounter = 1;
				int aux = counter;
				while (aux > 0) {
					int tempValue = array[aux];
					int previousTempValue = array[aux -1];
					if (tempValue > previousTempValue) {
						peakCounter++;
						aux--;
					} else {
						break;
					}
				}
				
				aux = counter;
				while (aux < array.length - 1) {
					int tempValue = array[aux];
					int nextTempValue = array[aux + 1];
					if (tempValue > nextTempValue) {
						peakCounter++;
						aux++;
					} else {
						break;
					}
				}
				
				if (peakCounter > greatestPeak) {
					greatestPeak = peakCounter;
				}
				
			}
			
			counter++;
			
		}

		return greatestPeak;
	}

	public static void main(String[] args) {
		System.out.println(longestPeak(new int[] { 1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3 }));
	}

}
