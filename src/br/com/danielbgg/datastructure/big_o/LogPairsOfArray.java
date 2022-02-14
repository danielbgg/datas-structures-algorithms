package br.com.danielbgg.datastructure.big_o;

public class LogPairsOfArray {

	public static void main(String[] args) {
		String[] boxes = new String[] {"a","b", "c", "d", "e"};
		for (int i = 0; i < boxes.length; i++) {
			for (int j = 0; j < boxes.length; j++) {
				System.out.println("[" + boxes[i] + "][" + boxes[j] + "]" );
			}
		}
	}
}
