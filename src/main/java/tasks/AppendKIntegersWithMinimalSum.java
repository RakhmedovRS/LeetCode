package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 3/6/2022
 */
@LeetCode(
		id = 2195,
		name = "Append K Integers With Minimal Sum",
		url = "https://leetcode.com/problems/append-k-integers-with-minimal-sum/",
		difficulty = Difficulty.MEDIUM
)
public class AppendKIntegersWithMinimalSum {
	public long minimalKSum(int[] nums, long k) {
		long answer = 0;
		Arrays.sort(nums);
		if (nums[0] > 1) {
			long end = Math.min(nums[0] - 1, k);
			answer += end * (1 + end) / 2;
			k -= end;
		}

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] - 1 - nums[i - 1] > 0) {
				long end = Math.min((nums[i] - 1) - (nums[i - 1] + 1) + 1, k);
				answer += end * (nums[i - 1] + 1 + nums[i - 1] + end) / 2;
				k -= end;
			}
		}

		if (k > 0) {
			answer += k * (nums[nums.length - 1] + 1 + (nums[nums.length - 1] + k)) / 2;
		}

		return answer;
	}
}
