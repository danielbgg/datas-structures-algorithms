package br.com.danielbgg.algoexpert.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TournamentWinner {

	//time: O(n) | space: O(k)
	public static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
		// Write your code here.
		Map<String, Integer> cache = new HashMap<String, Integer>();

		String winner = null;
		int greatestScore = 0;
		
		for (int i = 0; i < competitions.size(); i++) {
			ArrayList<String> game = competitions.get(i);
			String homeTeam = game.get(0);
			String awayTeam = game.get(1);
			Integer result = results.get(i);
			
			if (cache.get(homeTeam) == null) {
				cache.put(homeTeam, 0);
			}
			if (cache.get(awayTeam) == null) {
				cache.put(awayTeam, 0);
			}
			if (result == 0) {
				//+1 awayTeam
				Integer score = cache.get(awayTeam);
				cache.replace(awayTeam, ++score);
				if (score > greatestScore) {
					greatestScore = score;
					winner = awayTeam;
				}
			} else {
				//+1 homeTeam
				Integer score = cache.get(homeTeam);
				cache.replace(homeTeam, ++score);
				if (score > greatestScore) {
					greatestScore = score;
					winner = homeTeam;
				}
			}
		}

		return winner;
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> g1 = new ArrayList<String>();
		g1.add("HTML");
		g1.add("C#");

		ArrayList<String> g2 = new ArrayList<String>();
		g2.add("C#");
		g2.add("Python");

		ArrayList<String> g3 = new ArrayList<String>();
		g3.add("Python");
		g3.add("HTML");

		ArrayList<ArrayList<String>> competitions = new ArrayList<ArrayList<String>>();
		competitions.add(g1);
		competitions.add(g2);
		competitions.add(g3);

		ArrayList<Integer> results = new ArrayList<Integer>();
		results.add(0);
		results.add(0);
		results.add(1);

		System.out.println(tournamentWinner(competitions, results));
	}

}
