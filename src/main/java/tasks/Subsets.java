package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 09-Apr-20
 */
@LeetCode(id = 78, name = "Subsets", url = "https://leetcode.com/problems/subsets/")
public class Subsets
{
	public List<List<Integer>> subsets(int[] nums)
	{
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0)
		{
			return result;
		}
		result.add(new ArrayList<>());

		for (int i = nums.length - 1; i >= 0; i--)
		{
			int size = result.size();
			for (int pos = 0; pos < size; pos++)
			{
				List<Integer> newSet = new ArrayList<>(result.get(pos));
				newSet.add(nums[i]);
				result.add(newSet);
			}
		}

		return result;
	}
}
