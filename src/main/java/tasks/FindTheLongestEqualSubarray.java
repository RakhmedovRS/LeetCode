package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 8/19/2023
 */
@LeetCode(
		id = 2831,
		name = "Find the Longest Equal Subarray",
		url = "https://leetcode.com/problems/find-the-longest-equal-subarray/",
		difficulty = Difficulty.MEDIUM
)
public class FindTheLongestEqualSubarray
{
	public int longestEqualSubarray(List<Integer> nums, int k)
	{
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < nums.size(); i++)
		{
			map.putIfAbsent(nums.get(i), new ArrayList<>());
			map.get(nums.get(i)).add(i);
		}

		int max = 1;
		for (List<Integer> list : map.values())
		{
			int left = 0;
			int right = 0;
			int diff = 0;
			while (right < list.size() - 1)
			{
				while (diff > k)
				{
					diff -= list.get(left + 1) - list.get(left) - 1;
					left++;
				}

				if (right + 1 < list.size())
				{
					diff += list.get(right + 1) - list.get(right) - 1;
					right++;
				}

				if (diff <= k)
				{
					max = Math.max(max, right - left + 1);
				}
			}
		}

		return max;
	}
}
