package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 9/23/2023
 */
@LeetCode(
		id = 2865,
		name = "Beautiful Towers I",
		url = "https://leetcode.com/problems/beautiful-towers-i/",
		difficulty = Difficulty.MEDIUM
)
public class BeautifulTowersI {
	public long maximumSumOfHeights(List<Integer> maxHeights) {

		long max = 0;
		for (int i = 0; i < maxHeights.size(); i++) {
			max = Math.max(max, dfs(i, maxHeights));
		}

		return max;
	}

	private long dfs(int i, List<Integer> maxHeights) {
		long sum = maxHeights.get(i);
		int left = i - 1;
		int currMax = maxHeights.get(i);
		while (left >= 0) {
			currMax = Math.min(currMax, maxHeights.get(left--));
			sum += currMax;
		}

		int right = i + 1;
		currMax = maxHeights.get(i);
		while (right < maxHeights.size()) {
			currMax = Math.min(currMax, maxHeights.get(right++));
			sum += currMax;
		}

		return sum;
	}
}
