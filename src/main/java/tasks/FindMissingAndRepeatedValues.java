package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.TreeSet;

/**
 * @author Ruslan Rakhmedov
 * @created 12/16/2023
 */
@LeetCode(
		id = 2965,
		name = "Find Missing and Repeated Values",
		url = "https://leetcode.com/problems/find-missing-and-repeated-values/",
		difficulty = Difficulty.EASY
)
public class FindMissingAndRepeatedValues {
	public int[] findMissingAndRepeatedValues(int[][] grid) {
		TreeSet<Integer> set = new TreeSet<>();
		int dup = 0;
		for (int[] g : grid) {
			for (int val : g) {
				if (!set.add(val)) {
					dup = val;
				}
			}
		}

		int miss = 1;
		for (int val : set) {
			if (val != miss) {
				break;
			}
			miss++;
		}

		return new int[]{dup, miss};
	}
}
