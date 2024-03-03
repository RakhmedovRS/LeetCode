package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.PriorityQueue;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-03-02
 */
@LeetCode(
		id = 3066,
		name = "Minimum Operations to Exceed Threshold Value II",
		url = "https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumOperationsToExceedThresholdValueII {
	public int minOperations(int[] nums, int k) {
		PriorityQueue<Long> pq = new PriorityQueue<>();
		int cnt = 0;
		for (int num : nums) {
			pq.add((long) num);
		}

		while (pq.size() > 1 && pq.peek() < k) {
			long a = pq.remove();
			long b = pq.remove();

			pq.add(a * 2 + b);
			cnt++;
		}

		return cnt;
	}
}