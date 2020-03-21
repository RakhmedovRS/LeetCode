import common.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 21-Mar-20
 */
@LeetCode(id = 56, name = "Merge Intervals", url = "https://leetcode.com/problems/merge-intervals/")
public class MergeIntervals
{
	public int[][] merge(int[][] intervals)
	{
		if (intervals == null || intervals.length == 0)
		{
			return new int[0][0];
		}

		LinkedList<int[]> unmerged = new LinkedList<>();
		for (int[] interval : intervals)
		{
			unmerged.addLast(interval);
		}

		unmerged.sort(Comparator.comparingInt(anInt -> anInt[0]));

		int[] currentInterval;
		LinkedList<int[]> merged = new LinkedList<>();
		while (true)
		{
			currentInterval = unmerged.removeFirst();
			if (unmerged.isEmpty())
			{
				merged.addLast(currentInterval);
				break;
			}

			int[] nextInterval = unmerged.removeFirst();
			if (currentInterval[1] >= nextInterval[0])
			{
				currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
				unmerged.addFirst(currentInterval);
			}
			else
			{
				merged.addLast(currentInterval);
				unmerged.addFirst(nextInterval);
			}
		}

		int[][] res = new int[merged.size()][];
		int pos = 0;
		for (int[] interval : merged)
		{
			res[pos++] = interval;
		}

		return res;
	}

	public static void main(String[] args)
	{
		System.out.println(Arrays.deepToString(new MergeIntervals().merge(new int[][]{{1, 4}, {2, 3}})));
		System.out.println(Arrays.deepToString(new MergeIntervals().merge(new int[][]{{1, 4}, {0, 4}})));
		System.out.println(Arrays.deepToString(new MergeIntervals().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
		System.out.println(Arrays.deepToString(new MergeIntervals().merge(new int[][]{{}})));
	}
}
