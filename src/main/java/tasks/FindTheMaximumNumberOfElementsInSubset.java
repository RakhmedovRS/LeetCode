package tasks;import common.Difficulty;import common.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-01-27
 */
@LeetCode(
id = 3020,
 name = "Find the Maximum Number of Elements in Subset",
 url = "https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/description/",
 difficulty = Difficulty.MEDIUM
)
public class FindTheMaximumNumberOfElementsInSubset {
	public int maximumLength(int[] nums) {
		Map<Long, Integer> map = new HashMap<>();
		for (long num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		int max = 1;
		if (map.containsKey(1L)){
			int count = map.remove(1L);
			if (count % 2 == 1){
				max = count;
			}
			else {
				max = count - 1;
			}
		}

		PriorityQueue<Long> pq = new PriorityQueue<>();
		pq.addAll(map.keySet());

		while (!pq.isEmpty()) {
			long currVal = pq.remove();
			if (!map.containsKey(currVal)) {
				continue;
			}
			int currCount = map.remove(currVal);
			if (currCount >= 2) {
				int currLen = 2;
				while (map.containsKey(currVal * currVal)) {
					int count = map.remove(currVal * currVal);
					if (count >= 2) {
						currLen += 2;
						currVal *= currVal;
					} else if (count == 1) {
						currLen += 2;
						break;
					}
				}

				currLen--;

				max = Math.max(max, currLen);
			}
		}

		return max;
	}
}