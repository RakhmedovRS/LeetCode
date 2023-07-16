package tasks;

import common.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

@LeetCode(id = 436, name = "Find Right Interval", url = "https://leetcode.com/problems/find-right-interval/")
public class FindRightInterval
{
	public int[] findRightInterval(int[][] intervals)
	{
		int[][] pairs = new int[intervals.length][];
		for (int i = 0; i < intervals.length; i++)
		{
			pairs[i] = new int[]{intervals[i][0], intervals[i][1], i};
		}

		Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));

		int[] answer = new int[intervals.length];
		Arrays.fill(answer, -1);
		for (int i = 0; i < intervals.length; i++)
		{
			int index = binarySearch(pairs, intervals[i][1]);
			if (index != -1)
			{
				answer[i] = pairs[index][2];
			}
		}

		return answer;
	}

	private int binarySearch(int[][] pairs, int val)
	{
		int left = 0;
		int right = pairs.length - 1;
		int mid;
		while (left < right)
		{
			mid = left + (right - left) / 2;
			if (pairs[mid][0] >= val)
			{
				right = mid;
			}
			else
			{
				left = mid + 1;
			}
		}

		return pairs[right][0] >= val ? right : -1;
	}

	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(new FindRightInterval().findRightInterval(new int[][]
				{
						{3, 4},
						{2, 3},
						{1, 2}
				})));

		System.out.println(Arrays.toString(new FindRightInterval().findRightInterval(new int[][]
				{
						{1, 4},
						{2, 3},
						{3, 4}
				})));
	}
}
