package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.PriorityQueue;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-08-24
 */
@LeetCode(
		id = 3264,
		name = "Final Array State After K Multiplication Operations I",
		url = "https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/description/",
		difficulty = Difficulty.EASY
)
public class FinalArrayStateAfterKMultiplicationOperationsI {
	public int[] getFinalState(int[] nums, int k, int multiplier) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			if (a[0] == b[0]) {
				return a[1] - b[1];
			}
			return a[0] - b[0];
		});


		for (int i = 0; i < nums.length; i++) {
			pq.add(new int[]{nums[i], i});
		}

		while (k-- > 0) {
			int[] curr = pq.remove();
			curr[0] *= multiplier;
			pq.add(curr);
		}

		for (int[] curr : pq) {
			nums[curr[1]] = curr[0];
		}
		return nums;
	}
}