package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 21-Mar-20
 */
@LeetCode(id = 57, name = "Insert Interval", url = "https://leetcode.com/problems/insert-interval/")
public class InsertInterval
{
	public int[][] insert(int[][] intervals, int[] newInterval)
	{
		List<int[]> list = new ArrayList<>();
		boolean inserted = false;
		for (int[] interval : intervals)
		{
			if ((newInterval[0] >= interval[0] && newInterval[0] <= interval[1])
					|| (interval[0] >= newInterval[0] && interval[0] <= newInterval[1]))
			{
				newInterval[0] = Math.min(newInterval[0], interval[0]);
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			}
			else if (interval[0] > newInterval[1])
			{
				if (!inserted)
				{
					list.add(newInterval);
					inserted = true;
				}
				list.add(interval);
			}
			else
			{
				list.add(interval);
			}
		}

		if (!inserted)
		{
			list.add(newInterval);
		}

		int[][] answer = new int[list.size()][];
		for (int i = 0; i < list.size(); i++)
		{
			answer[i] = list.get(i);
		}

		return answer;
	}

	public static void main(String[] args)
	{
		System.out.println(Arrays.deepToString(new InsertInterval().insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
		System.out.println(Arrays.deepToString(new InsertInterval().insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
	}
}
