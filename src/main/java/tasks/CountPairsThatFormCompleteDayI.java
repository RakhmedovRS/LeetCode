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
		id = 3184,
		name = "Count Pairs That Form a Complete Day I",
		url = "https://leetcode.com/problems/count-pairs-that-form-a-complete-day-i/description/",
		difficulty = Difficulty.EASY
)
public class CountPairsThatFormCompleteDayI {
	public int countCompleteDayPairs(int[] hours) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] ans = new int[1];
		for (int h : hours) {
			map.forEach((hour, count) -> {
				if ((hour + h) % 24 == 0) {
					ans[0] += count;
				}
			});
			map.put(h % 24, map.getOrDefault(h % 24, 0) + 1);
		}
		return ans[0];
	}
}