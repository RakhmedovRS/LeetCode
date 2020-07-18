import common.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 18-Jul-20
 */
@LeetCode(id = 480, name = "Sliding Window Median", url = "https://leetcode.com/problems/sliding-window-median/")
public class SlidingWindowMedian
{
	public double[] medianSlidingWindow(int[] nums, int k)
	{
		if (nums.length == 0 || k == 0)
		{
			return new double[0];
		}
		double[] answer = new double[nums.length - k + 1];

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i = 0; i < nums.length; i++)
		{
			if (minHeap.size() > 0 && nums[i] > minHeap.peek())
			{
				minHeap.add(nums[i]);
			}
			else
			{
				maxHeap.add(nums[i]);
			}

			balanceHeaps(minHeap, maxHeap);

			if (i >= k - 1)
			{
				answer[i - k + 1] = median(minHeap, maxHeap);
				if (nums[i - k + 1] <= maxHeap.peek())
				{
					maxHeap.remove(nums[i - k + 1]);
				}
				else
				{
					minHeap.remove(nums[i - k + 1]);
				}

				balanceHeaps(minHeap, maxHeap);
			}
		}

		return answer;
	}

	private void balanceHeaps(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap)
	{
		if (minHeap.size() - maxHeap.size() > 1)
		{
			maxHeap.add(minHeap.poll());
		}
		else if (maxHeap.size() - minHeap.size() > 1)
		{
			minHeap.add(maxHeap.poll());
		}
	}

	private double median(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap)
	{
		if (minHeap.size() == maxHeap.size())
		{
			return minHeap.peek() / 2D + maxHeap.peek() / 2D;
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

	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(new SlidingWindowMedian().medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
	}
}
