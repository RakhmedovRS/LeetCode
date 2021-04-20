package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 14-May-20
 */
@LeetCode(id = 219, name = "Contains Duplicate II", url = "https://leetcode.com/problems/contains-duplicate-ii/")
public class ContainsDuplicateII
{
	public boolean containsNearbyDuplicate(int[] nums, int k)
	{
		if (nums == null || nums.length < 2)
		{
			return false;
		}

		Map<Integer, List<Integer>> valueToPosition = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
		{
			List<Integer> indices = valueToPosition.get(nums[i]);
			if (indices != null)
			{
				for (int index : indices)
				{
					if (Math.abs(i - index) <= k)
					{
						return true;
					}
				}
			}
			else
			{
				indices = new ArrayList<>();
			}
			indices.add(i);
			valueToPosition.put(nums[i], indices);
		}

		return false;
	}
}
