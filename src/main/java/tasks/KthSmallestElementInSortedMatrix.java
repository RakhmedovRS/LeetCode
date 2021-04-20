package tasks;

import common.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 28-Apr-20
 */
@LeetCode(id = 378, name = "Kth Smallest Element in a Sorted Matrix", url = "https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/")
public class KthSmallestElementInSortedMatrix
{
	public int kthSmallest(int[][] matrix, int k)
	{
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
		for (int[] ints : matrix)
		{
			for (int anInt : ints)
			{
				if (priorityQueue.size() < k)
				{
					priorityQueue.add(anInt);
				}
				else
				{
					if (anInt < priorityQueue.peek())
					{
						priorityQueue.remove();
						priorityQueue.add(anInt);
					}
				}
			}
		}

		return priorityQueue.peek();
	}
}
