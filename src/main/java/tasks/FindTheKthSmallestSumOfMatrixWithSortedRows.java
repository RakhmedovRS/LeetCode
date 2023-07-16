package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 2/26/2021
 */
@LeetCode(
		id = 1439,
		name = "Find the Kth Smallest Sum of a Matrix With Sorted Rows",
		url = "https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/",
		difficulty = Difficulty.HARD
)
public class FindTheKthSmallestSumOfMatrixWithSortedRows
{
	public int kthSmallest(int[][] mat, int k)
	{
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		maxHeap.add(0);
		for (int[] row : mat)
		{
			int currentSum;
			PriorityQueue<Integer> nextLevelMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());
			while (!maxHeap.isEmpty())
			{
				currentSum = maxHeap.remove();

				for (int val : row)
				{
					nextLevelMaxHeap.add(currentSum + val);
					if (nextLevelMaxHeap.size() > k)
					{
						nextLevelMaxHeap.remove();
					}
				}
			}

			maxHeap = nextLevelMaxHeap;
		}

		return maxHeap.peek();
	}
}
