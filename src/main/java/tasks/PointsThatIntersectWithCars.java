package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 9/9/2023
 */
@LeetCode(
		id = 2848,
		name = "Points That Intersect With Cars",
		url = "https://leetcode.com/problems/points-that-intersect-with-cars/",
		difficulty = Difficulty.EASY
)
public class PointsThatIntersectWithCars
{
	public int numberOfPoints(List<List<Integer>> nums)
	{
		Set<Integer> set = new HashSet<>();
		for (List<Integer> list: nums)
		{
			for (int i = list.get(0); i <= list.get(1); i++)
			{
				set.add(i);
			}
		}

		return set.size();
	}
}
