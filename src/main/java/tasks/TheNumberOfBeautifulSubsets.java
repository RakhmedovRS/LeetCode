package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 3/25/2023
 */
@LeetCode(
		id = 2597,
		name = "The Number of Beautiful Subsets",
		url = "https://leetcode.com/problems/the-number-of-beautiful-subsets/",
		difficulty = Difficulty.MEDIUM
)
public class TheNumberOfBeautifulSubsets
{
	public int beautifulSubsets(int[] nums, int k)
	{
		int[] memo = new int[5000];
		return dfs(0, nums, new ArrayList<>(), memo, k);
	}

	private int dfs(int pos, int[] nums, List<Integer> list, int[] memo, int k)
	{
		if (pos >= nums.length)
		{
			if (list.isEmpty())
			{
				return 0;
			}

			for (Integer val : list)
			{
				if (memo[2000 + val + k] > 0 || memo[2000 + val - k] > 0)
				{
					return 0;
				}
			}

			return 1;
		}

		int exclude = dfs(pos + 1, nums, list, memo, k);

		memo[nums[pos] + 2000]++;
		list.add(nums[pos]);
		int include = dfs(pos + 1, nums, list, memo, k);
		memo[nums[pos] + 2000]--;
		list.remove(list.size() - 1);

		return include + exclude;
	}
}
