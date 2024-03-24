package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-03-23
 */
@LeetCode(
		id = 3092,
		name = "Most Frequent IDs",
		url = "https://leetcode.com/problems/most-frequent-ids/description/",
		difficulty = Difficulty.MEDIUM
)
public class MostFrequentIDs {
	public long[] mostFrequentIDs(int[] nums, int[] freqs) {
		Map<Integer, Long> ids = new HashMap<>();
		TreeSet<Integer> mostFreq = new TreeSet<>((a, b) -> {
			if (ids.getOrDefault(a, 0L).equals(ids.getOrDefault(b, 0L))) {
				return a - b;
			}
			return Long.compare(ids.getOrDefault(b, 0L), ids.getOrDefault(a, 0L));
		});

		long[] ans = new long[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			int freq = freqs[i];
			long currFreq = ids.getOrDefault(num, 0L);
			mostFreq.remove(num);
			ids.put(num, currFreq + freq);
			mostFreq.add(num);
			ans[i] = ids.getOrDefault(mostFreq.first(), 0L);
		}

		return ans;
	}
}