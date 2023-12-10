package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 10/24/2022
 */
@LeetCode(
		id = 2447,
		name = "Number of Subarrays With GCD Equal to K",
		url = "https://leetcode.com/problems/number-of-subarrays-with-gcd-equal-to-k/",
		difficulty = Difficulty.MEDIUM
)
public class NumberOfSubarraysWithGCDEqualToK {
	public int subarrayGCD(int[] nums, int k) {
		int answer = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == k) {
				answer++;
			}
			int gcd = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				gcd = gcd(gcd, nums[j]);
				if (gcd == k) {
					answer++;
				}
			}
		}

		return answer;
	}

	private int gcd(int x, int y) {
		if (y == 0) {
			return x;
		}
		return gcd(y, x % y);
	}
}
