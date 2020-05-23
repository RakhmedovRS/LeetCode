import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 23-May-20
 */
@LeetCode(id = 312, name = "Burst Balloons", url = "https://leetcode.com/problems/burst-balloons/")
public class BurstBalloons
{
	public int maxCoins(int[] nums)
	{
		int[][] memo = new int[nums.length][nums.length];
		for (int[] row : memo)
		{
			Arrays.fill(row, -1);
		}
		return maxCoins(nums, memo, 0, nums.length - 1);
	}

	public int maxCoins(int[] nums, int[][] memo, int start, int end)
	{
		if (start > end)
		{
			return 0;
		}

		if (memo[start][end] != -1)
		{
			return memo[start][end];
		}

		int max = 0;
		int curr;
		for (int i = start; i <= end; i++)
		{
			curr = maxCoins(nums, memo, start, i - 1)
				+ (get(nums, i) * get(nums, start - 1) * get(nums, end + 1))
				+ maxCoins(nums, memo, i + 1, end);
			if (curr > max)
			{
				max = curr;
			}
		}

		memo[start][end] = max;
		return max;
	}

	public int get(int[] nums, int i)
	{
		if (i == -1 || i == nums.length)
		{
			return 1;
		}
		return nums[i];
	}

	public static void main(String[] args)
	{
		System.out.println(new BurstBalloons().maxCoins(new int[]{3, 1, 5, 8}));
		System.out.println(new BurstBalloons().maxCoins(new int[]{8, 3, 4, 3, 5, 0, 5, 6, 6, 2, 8, 5, 6, 2, 3, 8, 3, 5, 1, 0, 2}));
	}
}
