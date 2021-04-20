package tasks;

import common.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 28-Mar-20
 */
@LeetCode(id = 1365, name = "How Many Numbers Are Smaller Than the Current Number", url = "https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/")
public class HowManyNumbersAreSmallerThanCurrentNumber
{
	public int[] smallerNumbersThanCurrent(int[] nums)
	{
		if (nums == null || nums.length == 0)
		{
			return new int[]{};
		}

		int[] clone = Arrays.copyOf(nums, nums.length);
		Arrays.sort(clone);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < clone.length; i++)
		{
			map.putIfAbsent(clone[i], i);
		}

		int[] result = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
		{
			result[i] = map.get(nums[i]);
		}

		return result;
	}

	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(new HowManyNumbersAreSmallerThanCurrentNumber().smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
	}
}
