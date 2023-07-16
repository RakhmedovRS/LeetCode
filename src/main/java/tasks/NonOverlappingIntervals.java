package tasks;

import common.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 15-Aug-20
 */
@LeetCode(id = 435, name = "Non-overlapping Intervals", url = "https://leetcode.com/problems/non-overlapping-intervals/")
public class NonOverlappingIntervals
{
	public int eraseOverlapIntervals(int[][] intervals)
	{
		Arrays.sort(intervals, (arr1, arr2) ->
		{
			if (arr1[1] == arr2[1])
			{
				return arr1[0] - arr2[0];
			}
			return arr1[1] - arr2[1];
		});

		LinkedList<int[]> stack = new LinkedList<>();
		for (int[] interval : intervals)
		{
			if (stack.isEmpty())
			{
				stack.add(interval);
			}
			else
			{
				if (stack.getLast()[1] <= interval[0])
				{
					stack.add(interval);
				}
			}
		}

		return intervals.length - stack.size();
	}

	public static void main(String[] args)
	{
		System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals(new int[][]
				{
						{1, 2},
						{2, 3},
						{3, 4},
						{1, 3}
				}));

		System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals(new int[][]
				{
						{1, 2},
						{1, 2},
						{1, 2}
				}));
	}
}
