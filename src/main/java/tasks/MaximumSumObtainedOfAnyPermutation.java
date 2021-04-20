package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 19-Sep-20
 */
@LeetCode(id = 1589, name = "Maximum Sum Obtained of Any Permutation", url = "https://leetcode.com/problems/maximum-sum-obtained-of-any-permutation/")
public class MaximumSumObtainedOfAnyPermutation
{
	public int maxSumRangeQuery(int[] nums, int[][] requests)
	{
		int[] memo = new int[nums.length + 1];
		for (int[] request : requests)
		{
			memo[request[0]]++;
			memo[request[1] + 1]--;
		}

		for (int i = 1; i < memo.length; i++)
		{
			memo[i] += memo[i - 1];
		}

		Arrays.sort(nums);
		List<Integer> counts = new ArrayList<>();
		for (int pos = 0; pos < memo.length; pos++)
		{
			if (memo[pos] > 0)
			{
				counts.add(pos);
			}
		}

		counts.sort((i1, i2) ->
		{
			if (memo[i1] == memo[i2])
			{
				return i1 - i2;
			}

			return memo[i1] - memo[i2];
		});

		long sum = 0;
		int mod = (int) Math.pow(10, 9) + 7;
		long values;
		int index;
		int numsPos = nums.length - 1;
		for (int i = counts.size() - 1; i >= 0; i--)
		{
			index = counts.get(i);
			values = nums[numsPos--];

			sum += (values * memo[index]) % mod;
			sum %= mod;
		}

		return (int) (sum % mod);
	}
}
