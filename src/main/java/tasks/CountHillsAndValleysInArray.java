package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 3/20/2022
 */
@LeetCode(
		id = 2210,
		name = "Count Hills and Valleys in an Array",
		url = "https://leetcode.com/problems/count-hills-and-valleys-in-an-array/",
		difficulty = Difficulty.EASY
)
public class CountHillsAndValleysInArray
{
	public int countHillValley(int[] nums)
	{

		List<Integer> list = new ArrayList<>();
		for (int num : nums)
		{
			if (list.isEmpty() || list.get(list.size() - 1) != num)
			{
				list.add(num);
			}
		}

		nums = list.stream().mapToInt(Integer::intValue).toArray();

		int count = 0;
		for (int i = 1; i < nums.length - 1; i++)
		{
			if (nums[i - 1] == nums[i] || nums[i] == nums[i + 1])
			{
				continue;
			}

			if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1])
			{
				count++;
			}

			if (nums[i - 1] > nums[i] && nums[i] < nums[i + 1])
			{
				count++;
			}

		}

		return count;
	}
}
