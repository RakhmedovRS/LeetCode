package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-05-04
 */
@LeetCode(
		id = 3137,
		name = "Minimum Number of Operations to Make Word K-Periodic",
		url = "https://leetcode.com/problems/minimum-number-of-operations-to-make-word-k-periodic/description/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumNumberOfOperationsToMakeWordKPeriodic {
	public int minimumOperationsToMakeKPeriodic(String word, int k) {
		Map<String, Integer> map = new HashMap<>();
		int max = 0;
		for (int i = 0; i < word.length(); i += k) {
			String sub = word.substring(i, i + k);
			map.put(sub, map.getOrDefault(sub, 0) + 1);
			max = Math.max(max, map.get(sub));
		}

		return word.length() / k - max;
	}
}