package tasks;

import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 22-Apr-20
 */
@LeetCode(id = 560, name = "Subarray Sum Equals K", url = "https://leetcode.com/problems/subarray-sum-equals-k/")
public class SubarraySumEqualsK
{
	public int subarraySum(int[] nums, int k)
	{
		int sum = 0;
		int count = 0;
		Map<Integer, Integer> sums = new HashMap<>();
		sums.put(0, 1);
		for (int num : nums)
		{
			sum += num;
			count += sums.getOrDefault(sum - k, 0);
			sums.put(sum, sums.getOrDefault(sum, 0) + 1);
		}

		return count;
	}
}
