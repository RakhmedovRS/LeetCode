package tasks;

import common.LeetCode;

import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 28-May-20
 */
@LeetCode(id = 703, name = "Kth Largest Element in a Stream", url = "https://leetcode.com/problems/kth-largest-element-in-a-stream/")
public class KthLargestElementInStream
{
	class KthLargest
	{

		private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		private int k;

		public KthLargest(int k, int[] nums)
		{
			this.k = k;
			for (int num : nums)
			{
				minHeap.add(num);
				if (minHeap.size() > k)
				{
					minHeap.remove();
				}
			}
		}

		public int add(int val)
		{
			if (minHeap.size() == k)
			{
				if (val > minHeap.peek())
				{
					minHeap.remove();
					minHeap.add(val);
				}
				return minHeap.peek();
			}
			else
			{
				minHeap.add(val);
				return minHeap.peek();
			}
		}
	}
}
