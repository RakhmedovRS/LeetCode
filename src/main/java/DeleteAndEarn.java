import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 10/23/2020
 */
@LeetCode(id = 740, name = "Delete and Earn", url = "https://leetcode.com/problems/delete-and-earn/")
public class DeleteAndEarn
{
	public int deleteAndEarn(int[] nums)
	{
		if (nums == null || nums.length == 0)
		{
			return 0;
		}
		if (nums.length == 1)
		{
			return nums[0];
		}

		Arrays.sort(nums);
		List<int[]> numbers = new ArrayList<>();
		numbers.add(new int[]{nums[0], 0});
		for (int num : nums)
		{
			if (numbers.get(numbers.size() - 1)[0] == num)
			{
				numbers.get(numbers.size() - 1)[1] += num;
			}
			else
			{
				numbers.add(new int[]{num, num});
			}
		}

		return dfs(0, numbers, new Integer[numbers.size()]);
	}

	private int dfs(int pos, List<int[]> numbers, Integer[] memo)
	{
		if (pos >= numbers.size())
		{
			return 0;
		}

		if (memo[pos] != null)
		{
			return memo[pos];
		}

		if (pos + 1 < numbers.size())
		{
			if (numbers.get(pos)[0] + 1 == numbers.get(pos + 1)[0])
			{
				memo[pos] = Math.max(numbers.get(pos)[1] + dfs(pos + 2, numbers, memo), dfs(pos + 1, numbers, memo));
			}
			else
			{
				memo[pos] = numbers.get(pos)[1] + dfs(pos + 1, numbers, memo);
			}
		}
		else
		{
			memo[pos] = numbers.get(pos)[1];
		}

		return memo[pos];
	}
}
