package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-06-21
 */
@LeetCode(
		id = 1248,
		name = "Count Number of Nice Subarrays",
		url = "https://leetcode.com/problems/count-number-of-nice-subarrays/description/",
		difficulty = Difficulty.MEDIUM
)
public class CountNumberOfNiceSubarrays {
	public int numberOfSubarrays(int[] nums, int k) {
		LinkedList<Integer> oddIndices = new LinkedList<>();
		int prevOdd = -1;
		int right = 0;
		int ans = 0;
		while (right < nums.length) {
			if (nums[right] % 2 == 1) {
				k--;
				oddIndices.addLast(right);
			}
			right++;

			if (k < 0) {
				prevOdd = oddIndices.removeFirst();
				k++;
			}

			if (k == 0) {
				ans += oddIndices.getFirst() - prevOdd;
			}
		}
		return ans;
	}
}