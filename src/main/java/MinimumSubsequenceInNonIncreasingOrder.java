import common.LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 10/8/2020
 */
@LeetCode(id = 1403, name = "Minimum Subsequence in Non-Increasing Order", url = "https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/")
public class MinimumSubsequenceInNonIncreasingOrder
{
	public List<Integer> minSubsequence(int[] nums)
	{
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		int sum = 0;
		for (int num : nums)
		{
			if (num > 0)
			{
				sum += num;
				maxHeap.add(num);
			}
		}

		List<Integer> answer = new ArrayList<>();
		int currentSum = 0;
		while (!maxHeap.isEmpty())
		{
			answer.add(maxHeap.peek());
			currentSum += maxHeap.peek();
			sum -= maxHeap.remove();
			if (currentSum > sum)
			{
				break;
			}
		}

		return answer;
	}

	public static void main(String[] args)
	{
		System.out.println(new MinimumSubsequenceInNonIncreasingOrder().minSubsequence(new int[]{4, 3, 10, 9, 8}));
	}
}
