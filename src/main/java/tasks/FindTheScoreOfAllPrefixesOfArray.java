package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 4/16/2023
 */
@LeetCode(
		id = 2640,
		name = "Find the Score of All Prefixes of an Array",
		url = "https://leetcode.com/problems/find-the-score-of-all-prefixes-of-an-array/",
		difficulty = Difficulty.MEDIUM
)
public class FindTheScoreOfAllPrefixesOfArray {
	public long[] findPrefixScore(int[] nums) {
		long[] arr = new long[nums.length];
		long max = 0;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
			arr[i] = max + nums[i];
		}

		for (int i = 1; i < arr.length; i++) {
			arr[i] += arr[i - 1];
		}

		return arr;
	}
}
