package tasks;

import common.LeetCode;

import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 10/21/2020
 */
@LeetCode(id = 1005, name = "Maximize Sum Of Array After K Negations", url = "https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/")
public class MaximizeSumOfArrayAfterKNegations
{
	public int largestSumAfterKNegations(int[] A, int K)
	{
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int num : A)
		{
			minHeap.add(num);
		}

		while (K-- > 0)
		{
			minHeap.add(minHeap.remove() * -1);
		}

		int sum = 0;
		for (int num : minHeap.toArray(new Integer[0]))
		{
			sum += num;
		}

		return sum;
	}
}
