import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 21-Mar-20
 */
@LeetCode(
	id = 56,
	name = "Merge Intervals",
	url = "https://leetcode.com/problems/merge-intervals/",
	difficulty = Difficulty.MEDIUM
)
public class MergeIntervals
{
	public int[][] merge(int[][] intervals)
	{
		Arrays.sort(intervals, (a, b) ->
		{
			if (a[1] == b[1])
			{
				return a[0] - b[0];
			}

			return a[1] - b[1];
		});

		LinkedList<int[]> list = new LinkedList<>();
		for (int[] interval : intervals)
		{
			if (!list.isEmpty() && list.getLast()[1] >= interval[0])
			{

				while (!list.isEmpty() && list.getLast()[1] >= interval[0])
				{
					interval[0] = Math.min(list.getLast()[0], interval[0]);
					interval[1] = Math.max(list.getLast()[1], interval[1]);
					list.removeLast();
				}
			}

			list.addLast(interval);
		}

		int pos = 0;
		int[][] answer = new int[list.size()][];
		for (int[] inteval : list)
		{
			answer[pos++] = inteval;
		}

		return answer;
	}

	public static void main(String[] args)
	{
		System.out.println(Arrays.deepToString(new MergeIntervals().merge(new int[][]{{1, 4}, {2, 3}})));
		System.out.println(Arrays.deepToString(new MergeIntervals().merge(new int[][]{{1, 4}, {0, 4}})));
		System.out.println(Arrays.deepToString(new MergeIntervals().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
		System.out.println(Arrays.deepToString(new MergeIntervals().merge(new int[][]{{}})));
	}
}
