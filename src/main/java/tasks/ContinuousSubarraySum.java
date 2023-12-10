package tasks;

import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 06-Aug-20
 */
@LeetCode(id = 523, name = "Continuous Subarray Sum", url = "https://leetcode.com/problems/continuous-subarray-sum/")
public class ContinuousSubarraySum {
	public boolean checkSubarraySum(int[] nums, int k) {
		Map<Integer, Integer> memo = new HashMap<>();
		memo.put(0, -1);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (k != 0) {
				sum %= k;
			}

			Integer prev = memo.get(sum);
			if (prev != null) {
				if (i - prev > 1) {
					return true;
				}
			}
			else {
				memo.put(sum, i);
			}
		}

		return false;
	}
}
