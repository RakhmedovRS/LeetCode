package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 3/14/2021
 */
@LeetCode(
	id = 1792,
	name = "Maximum Average Pass Ratio",
	url = "https://leetcode.com/problems/maximum-average-pass-ratio/",
	difficulty = Difficulty.MEDIUM
)
public class MaximumAveragePassRatio
{
	public double maxAverageRatio(int[][] classes, int extraStudents)
	{
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) ->
		{
			double aRatio = 1D * (a[0] + 1) / (a[1] + 1) - 1D * a[0] / a[1];
			double bRatio = 1D * (b[0] + 1) / (b[1] + 1) - 1D * b[0] / b[1];

			int c = Double.compare(bRatio, aRatio);
			if (c == 0)
			{
				return (a[1] - a[0]) - (b[1] - b[0]);
			}

			return c;
		});

		minHeap.addAll(Arrays.asList(classes));

		int[] current;

		while (!minHeap.isEmpty() && extraStudents-- > 0)
		{
			current = minHeap.remove();
			current[0]++;
			current[1]++;
			minHeap.add(current);
		}

		double sum = 0;
		while (!minHeap.isEmpty())
		{
			current = minHeap.remove();
			sum += 1D * current[0] / current[1];
		}

		return sum / classes.length;
	}

	public static void main(String[] args)
	{
		MaximumAveragePassRatio clazz = new MaximumAveragePassRatio();
		System.out.println(clazz.maxAverageRatio(new int[][]
			{
				{2, 4},
				{3, 9},
				{4, 5},
				{2, 10}
			}, 4
		));

		System.out.println(clazz.maxAverageRatio(new int[][]
			{
				{1, 2},
				{3, 5},
				{2, 2}
			}, 2
		));
	}
}
