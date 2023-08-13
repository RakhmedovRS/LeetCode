package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.List;
import java.util.TreeMap;

/**
 * @author Ruslan Rakhmedov
 * @created 8/12/2023
 */
@LeetCode(
		id = 2817,
		name = "Minimum Absolute Difference Between Elements With Constraint",
		url = "https://leetcode.com/problems/minimum-absolute-difference-between-elements-with-constraint/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumAbsoluteDifferenceBetweenElementsWithConstraint
{
	public int minAbsoluteDifference(List<Integer> nums, int x)
	{
		if (x == 0)
		{
			return 0;
		}

		int min = Integer.MAX_VALUE;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(nums.get(0), 1);
		for (int i = nums.size() - 1; i > x - 1; i--)
		{
			map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
		}

		for (int i = 0; i < nums.size() - x; i++)
		{
			int curr = nums.get(i);
			int cnt = map.remove(curr);
			if (cnt > 1)
			{
				map.put(curr, cnt - 1);
			}

			Integer cel = map.ceilingKey(curr);
			Integer floor = map.floorKey(curr);

			min = Math.min(min, Math.abs(cel == null ? Integer.MAX_VALUE : cel - curr));
			min = Math.min(min, Math.abs(floor == null ? Integer.MAX_VALUE : floor - curr));
/*			if (min == 0)
			{
				return 0;
			}*/

			if (x > 1 && i + 1 < nums.size())
			{
				map.put(nums.get(i + 1), map.getOrDefault(nums.get(i + 1), 0) + 1);
			}

			if (x > 1 && i + x < nums.size())
			{
				cnt = map.remove(nums.get(i + x));
				if (cnt > 1)
				{
					map.put(nums.get(i + x), cnt - 1);
				}
			}
		}

		return min;
	}
}
