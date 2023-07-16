package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 5/7/2023
 */
@LeetCode(
		id = 2670,
		name = "Find the Distinct Difference Array",
		url = "https://leetcode.com/problems/find-the-distinct-difference-array/",
		difficulty = Difficulty.EASY
)
public class FindTheDistinctDifferenceArray
{
	public int[] distinctDifferenceArray(int[] nums)
	{
		Set<Integer> set = new HashSet<>();
		int[] ans = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
		{
			set.add(nums[i]);

			Set<Integer> set2 = new HashSet<>();
			for (int j = i + 1; j < nums.length; j++)
			{
				set2.add(nums[j]);
			}

			ans[i] = set.size() - set2.size();
		}

		return ans;
	}
}
