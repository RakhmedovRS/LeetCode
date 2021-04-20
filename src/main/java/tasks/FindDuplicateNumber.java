package tasks;

import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 14-Apr-20
 */
@LeetCode(id = 287, name = "Find the Duplicate Number", url = "https://leetcode.com/problems/find-the-duplicate-number/")
public class FindDuplicateNumber
{
	public int findDuplicate(int[] nums)
	{
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++)
		{
			if (!set.add(nums[i]))
			{
				return nums[i];
			}
		}

		return -1;
	}
}
