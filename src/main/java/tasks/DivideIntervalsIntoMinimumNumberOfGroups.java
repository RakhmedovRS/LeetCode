package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 9/13/2022
 */
@LeetCode(
		id = 2406,
		name = "Divide Intervals Into Minimum Number of Groups",
		url = "https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/",
		difficulty = Difficulty.MEDIUM
)
public class DivideIntervalsIntoMinimumNumberOfGroups {
	public int minGroups(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> {
			if (a[0] == b[0]) {
				return a[1] - b[1];
			}

			return a[0] - b[0];
		});

		int[] memo = new int[(int) Math.pow(10, 6) + 1];
		for (int[] interval : intervals) {
			memo[interval[0]]++;
			if (interval[1] + 1 < memo.length) {
				memo[interval[1] + 1]--;
			}
		}

		int max = 0;
		for (int i = 1; i < memo.length; i++) {
			memo[i] += memo[i - 1];
			max = Math.max(max, memo[i]);
		}

		return max;
	}
}
