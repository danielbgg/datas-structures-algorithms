package br.com.danielbgg.algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {

	// time: O(nlogn) | space: O(n)
	public static int[][] mergeOverlappingIntervals(int[][] intervals) {
		List<int[]> list = new ArrayList<int[]>();
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		for (int i = 0; i < intervals.length; i++) {
			int[] data = intervals[i];
			boolean insert = true;
			for (int j = 0; j < list.size(); j++) {
				int[] mergedData = list.get(j);
				if (mergedData[1] >= data[0]) {
					if (mergedData[1] < data[1]) {
						mergedData[1] = data[1];
					}
					insert = false;
				}
			}
			if (insert)
				list.add(data);
		}
		return list.toArray(new int[list.size()][]);
	}

	public static void main(String[] args) {
//		 int[][] result = mergeOverlappingIntervals(new int[][] { { 1, 2 }, { 3, 5 },
//		 { 4, 7 }, { 6, 8 }, { 9, 10 } });
		int[][] result = mergeOverlappingIntervals(new int[][] { { 100, 105 }, { 1, 104 } });
//		int[][] result = mergeOverlappingIntervals(new int[][] { { 1, 22 }, { -20, 30 } });

		System.out.println("RESULT: ");
		for (int i = 0; i < result.length; i++) {
			int[] data = result[i];
			System.out.println(Arrays.toString(data));
		}

	}

}
