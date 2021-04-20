package tasks;

import common.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 16-Mar-20
 */
@LeetCode(id = 295, name = "Find Median from Data Stream", url = "https://leetcode.com/problems/find-median-from-data-stream/")
public class FindMedianFromDataStream
{
	class MedianFinder
	{
		PriorityQueue<Integer> minHeap;
		PriorityQueue<Integer> maxHeap;

		public MedianFinder()
		{
			minHeap = new PriorityQueue<>(Comparator.naturalOrder());
			maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
			minHeap.add(Integer.MAX_VALUE);
			maxHeap.add(Integer.MIN_VALUE);
		}

		public void addNum(int num)
		{
			if (num >= maxHeap.peek())
			{
				minHeap.add(num);
			}
			else
			{
				maxHeap.add(num);
			}

			if (Math.abs(maxHeap.size() - minHeap.size()) >= 2)
			{
				if (maxHeap.size() > minHeap.size())
				{
					minHeap.add(maxHeap.remove());
				}
				else
				{
					maxHeap.add(minHeap.remove());
				}
			}
		}

		public double findMedian()
		{
			if (minHeap.size() == maxHeap.size())
			{
				return (maxHeap.peek() + minHeap.peek()) / 2D;
			}
			else if (minHeap.size() > maxHeap.size())
			{
				return minHeap.peek();
			}
			else
			{
				return maxHeap.peek();
			}
		}
	}
}
