package tasks;

import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 15-Feb-20
 */
@LeetCode(id = 1, name = "Two Sum", url = "https://leetcode.com/problems/two-sum/")
public class TwoSum
{
	public int[] twoSum(int[] nums, int target)
	{
		Map<Integer, Integer> seen = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
		{
			if (seen.containsKey(target - nums[i]))
			{
				if (seen.get(target - nums[i]) != i)
				{
					return new int[]{seen.get(target - nums[i]), i};
				}
				else
				{
					continue;
				}
			}

			seen.put(nums[i], i);
		}

		return new int[0];
	}
}
