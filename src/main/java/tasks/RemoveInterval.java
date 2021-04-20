package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 11/29/2020
 */
@LeetCode(
	id = 1272,
	name = "Remove Interval",
	url = "https://leetcode.com/problems/remove-interval/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class RemoveInterval
{
	public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved)
	{
		List<List<Integer>> answer = new ArrayList<>();
		for (int[] interval : intervals)
		{
			if (toBeRemoved[0] <= interval[0] && interval[1] <= toBeRemoved[1])
			{
				continue;
			}
			else if (interval[0] <= toBeRemoved[0] && toBeRemoved[1] <= interval[1])
			{
				if (interval[0] != toBeRemoved[0])
				{
					answer.add(Arrays.asList(interval[0], toBeRemoved[0]));
				}

				if (toBeRemoved[1] != interval[1])
				{
					answer.add(Arrays.asList(toBeRemoved[1], interval[1]));
				}
			}
			else if (interval[1] >= toBeRemoved[0] && interval[1] <= toBeRemoved[1])
			{
				answer.add(Arrays.asList(interval[0], toBeRemoved[0]));
			}
			else if (toBeRemoved[0] <= interval[0] && interval[0] <= toBeRemoved[1])
			{
				answer.add(Arrays.asList(toBeRemoved[1], interval[1]));
			}
			else
			{
				answer.add(Arrays.asList(interval[0], interval[1]));
			}
		}

		return answer;
	}

	public static void main(String[] args)
	{
		System.out.println(new RemoveInterval().removeInterval(new int[][]
			{
				{0, 100}
			}, new int[]{0, 50}));

		System.out.println(new RemoveInterval().removeInterval(new int[][]
			{
				{1, 2},
				{2, 3},
				{4, 4},
				{4, 5},
				{6, 7},
				{8, 9},
			}, new int[]{1, 10}));

		System.out.println(new RemoveInterval().removeInterval(new int[][]
			{
				{0, 5}
			}, new int[]{2, 3}));

		System.out.println(new RemoveInterval().removeInterval(new int[][]
			{
				{0, 2},
				{3, 4},
				{5, 7}
			}, new int[]{1, 6}));

		System.out.println(new RemoveInterval().removeInterval(new int[][]
			{
				{-5, -4},
				{-3, -2},
				{1, 2},
				{3, 5},
				{8, 9},
			}, new int[]{-1, 4}));
	}
}
