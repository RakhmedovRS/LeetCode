package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 15-Feb-20
 */
@LeetCode(
	id = 1,
	name = "Two Sum",
	url = "https://leetcode.com/problems/two-sum/",
	difficulty = Difficulty.EASY
)
public class TwoSum
{
	public int[] twoSum(int[] nums, int target)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
		{
			if (map.containsKey(target - nums[i]))
			{
				return new int[]{i, map.get(target - nums[i])};
			}
			map.put(nums[i], i);
		}

		return new int[0];
	}
}
