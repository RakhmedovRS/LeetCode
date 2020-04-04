import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 03-Mar-20
 */
@LeetCode(id = 169, name = "Majority Element", url = "https://leetcode.com/problems/majority-element/")
public class MajorityElement
{
	public int majorityElement(int[] nums)
	{
		if (nums == null || nums.length == 0)
		{
			return 0;
		}

		int candidate = nums[0];
		int count = 1;
		for (int i = 1; i < nums.length; i++)
		{
			if (count == 0)
			{
				candidate = nums[i];
			}

			count += candidate == nums[i] ? 1 : -1;
		}

		return candidate;
	}

	public int majorityElement3(int[] nums)
	{
		Map<Integer, Integer> cache = new HashMap<>();
		int max = Integer.MIN_VALUE;
		int majorityElementIndex = 0;
		for (int i = 0; i < nums.length; i++)
		{
			int newValue = cache.getOrDefault(nums[i], 0) + 1;
			cache.put(nums[i], newValue);
			if (newValue > max)
			{
				max = newValue;
				majorityElementIndex = i;
			}
		}

		return nums[majorityElementIndex];
	}

	public int majorityElement1(int[] nums)
	{
		int count = 1;
		int majorityElement = nums[0];
		for (int i = 1; i < nums.length; i++)
		{
			if (nums[i] == majorityElement)
			{
				count++;
			}
			else
			{
				count--;
			}

			if (count == 0)
			{
				majorityElement = nums[i];
				count++;
			}
		}

		return majorityElement;
	}

	public static void main(String[] args)
	{
		System.out.println(new MajorityElement().majorityElement(new int[]{10, 9, 9, 9, 10}));
	}
}
