package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 4/10/2022
 */
@LeetCode(
	id = 2233,
	name = "Maximum Product After K Increments",
	url = "https://leetcode.com/problems/maximum-product-after-k-increments/",
	difficulty = Difficulty.MEDIUM
)
public class MaximumProductAfterKIncrements
{
	public int maximumProduct(int[] nums, int k)
	{
		if (nums.length == 0)
		{
			return 0;
		}

		if (nums.length == 1)
		{
			return nums[0] + k;
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int num : nums)
		{
			pq.add(num);
		}

		while (k > 0)
		{
			pq.add(pq.remove() + 1);
			k--;
		}

		long n = pq.remove();
		while (!pq.isEmpty())
		{
			n = (n * pq.remove()) % 1_000_000_007;
		}

		return (int) n;
	}
}
