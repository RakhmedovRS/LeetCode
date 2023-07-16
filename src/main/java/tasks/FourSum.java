package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 7/16/2021
 */
@LeetCode(
		id = 18,
		name = "4Sum",
		url = "https://leetcode.com/problems/4sum/",
		difficulty = Difficulty.MEDIUM
)
public class FourSum
{
	private boolean contains(int[] nums, int left, int value)
	{
		int right = nums.length;
		int mid;
		while (left < right)
		{
			mid = (left + right) / 2;
			if (nums[mid] == value)
			{
				return true;
			}
			else
			{
				if (value > nums[mid])
				{
					left = mid + 1;
				}
				else
				{
					right = mid;
				}
			}
		}
		return false;
	}

	public List<List<Integer>> fourSum(int[] nums, int target)
	{
		if (nums.length == 0)
		{
			return new ArrayList<>();
		}

		Arrays.sort(nums);
		if (nums[0] > 0)
		{
			return new ArrayList<>();
		}

		List<List<Integer>> retList = new ArrayList<>();
		List<Integer> l;
		Set<String> cache = new HashSet<>();
		outer:
		for (int first = 0; first < nums.length - 3; first++)
		{
			for (int second = first + 1; second < nums.length - 2; second++)
			{
				for (int third = second + 1; third < nums.length - 1; third++)
				{
					int searchValue = target - (nums[first] + nums[second] + nums[third]);
					if (contains(nums, third + 1, searchValue))
					{
						l = Arrays.asList(nums[first], nums[second], nums[third], searchValue);
						String a = Arrays.toString(l.toArray());
						if (!cache.contains(a))
						{
							retList.add(l);
							cache.add(a);
						}
					}
				}
			}
		}
		return retList;
	}
}
