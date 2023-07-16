package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 1/8/2021
 */
@LeetCode(
		id = 1590,
		name = "Make Sum Divisible by P",
		url = "https://leetcode.com/problems/make-sum-divisible-by-p/",
		difficulty = Difficulty.MEDIUM
)
public class MakeSumDivisibleByP
{
	public int minSubarray(int[] nums, int p)
	{
		int totalReminder = 0;
		for (int num : nums)
		{
			totalReminder = (totalReminder + num) % p;
		}

		if (totalReminder == 0)
		{
			return 0;
		}

		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int currentReminder = 0;
		int result = nums.length;
		for (int i = 0; i < nums.length; i++)
		{
			currentReminder = (currentReminder + nums[i]) % p;
			int desire = (currentReminder - totalReminder + p) % p;
			if (map.containsKey(desire))
			{

				result = Math.min(result, i - map.get(desire));
			}
			map.put(currentReminder, i);
		}

		return result == nums.length ? -1 : result;
	}
}
