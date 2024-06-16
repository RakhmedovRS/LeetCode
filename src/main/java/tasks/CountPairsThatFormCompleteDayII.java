package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-06-16
 */
@LeetCode(
		id = 3185,
		name = "Count Pairs That Form a Complete Day II",
		url = "https://leetcode.com/problems/count-pairs-that-form-a-complete-day-ii/description/",
		difficulty = Difficulty.MEDIUM
)
public class CountPairsThatFormCompleteDayII {
	public long countCompleteDayPairs(int[] hours) {
		Map<Integer, Long> map = new HashMap<>();
		long[] ans = new long[1];
		for (int h : hours) {
			map.forEach((hour, count) -> {
				if ((hour + h) % 24 == 0) {
					ans[0] += count;
				}
			});
			map.put(h % 24, map.getOrDefault(h % 24, 0L) + 1);
		}
		return ans[0];
	}
}