package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/15/2020
 */
@LeetCode(
	id = 1658,
	name = "Minimum Operations to Reduce X to Zero",
	url = "https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/",
	difficulty = Difficulty.MEDIUM
)
public class MinimumOperationsToReduceXToZero
{
	public int minOperations(int[] nums, int x)
	{
		int n = nums.length;
		boolean[] used = new boolean[n];
		int i = 0;
		int j = 0;

		int totalSum = 0;
		for (int num : nums)
		{
			totalSum += num;
		}

		if (totalSum < x)
		{
			return -1;
		}
		else if (totalSum == x)
		{
			return n;
		}

		int steps = 0;
		int minSteps = Integer.MAX_VALUE;
		int sum = 0;
		while (j < n * 2)
		{
			while (sum <= x && !used[j % n])
			{
				sum += nums[j % n];
				used[j++ % n] = true;
				steps++;

				if (sum == x && (used[0] || used[n - 1]))
				{
					minSteps = Math.min(minSteps, steps);
				}
			}

			while (sum > x)
			{
				sum -= nums[i % n];
				used[i++ % n] = false;
				steps--;
				if (sum == x && (used[0] || used[n - 1]))
				{
					minSteps = Math.min(minSteps, steps);
				}
			}
		}

		return minSteps == Integer.MAX_VALUE ? -1 : minSteps;
	}

	public static void main(String[] args)
	{
		System.out.println(new MinimumOperationsToReduceXToZero().minOperations(new int[]{5, 2, 3, 1, 1}, 5)); //1
		System.out.println(new MinimumOperationsToReduceXToZero().minOperations(new int[]{1, 1}, 3)); //-1
		System.out.println(new MinimumOperationsToReduceXToZero().minOperations(new int[]{5, 6, 7, 8, 9}, 4)); //-1
		System.out.println(new MinimumOperationsToReduceXToZero().minOperations(new int[]{1, 1, 3, 2, 5}, 5)); //1
		System.out.println(new MinimumOperationsToReduceXToZero().minOperations(new int[]{1, 1, 4, 2, 3}, 5)); //2
		System.out.println(new MinimumOperationsToReduceXToZero().minOperations(new int[]{
			8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309}, 134365)); //16
		System.out.println(new MinimumOperationsToReduceXToZero().minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10)); //5
	}
}
