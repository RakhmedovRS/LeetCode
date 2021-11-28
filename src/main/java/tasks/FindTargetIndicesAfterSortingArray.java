package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 11/28/2021
 */
@LeetCode(
	id = 2089,
	name = "Find Target Indices After Sorting Array",
	url = "https://leetcode.com/problems/find-target-indices-after-sorting-array/",
	difficulty = Difficulty.EASY
)
public class FindTargetIndicesAfterSortingArray
{
	public List<Integer> targetIndices(int[] nums, int target)
	{
		List<Integer> list = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] == target)
			{
				list.add(i);
			}
		}
		return list;
	}
}
