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
		List<int[]> answer = new ArrayList<>();

		for (int[] interval : intervals)
		{
			if (newInterval[1] < interval[0])
			{
				answer.add(newInterval);
				newInterval = interval;
			}
			else if (newInterval[0] <= interval[1])
			{
				newInterval = new int[]{
					Math.min(interval[0], newInterval[0]),
					Math.max(interval[1], newInterval[1])};
			}
			else
			{
				answer.add(interval);
			}
		}
		answer.add(newInterval);
		return answer.toArray(new int[answer.size()][2]);
	}

	public static void main(String[] args)
	{
		System.out.println(Arrays.deepToString(
			new InsertInterval()
				.insert(
					new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
					new int[]{4, 8}
				)
			)
		);
	}
}
