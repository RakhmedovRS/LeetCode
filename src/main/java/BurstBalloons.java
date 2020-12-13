import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 23-May-20
 */
@LeetCode(
	id = 312,
	name = "Burst Balloons",
	url = "https://leetcode.com/problems/burst-balloons/",
	difficulty = Difficulty.MEDIUM)
public class BurstBalloons
{
	public int maxCoins(int[] nums)
	{
		int[] copy = new int[nums.length + 2];
		copy[0] = 1;
		copy[copy.length - 1] = 1;
		for (int i = 0; i < nums.length; i++)
		{
			copy[i + 1] = nums[i];
		}

		return dfs(copy, 0, copy.length - 1, new Integer[copy.length][copy.length]);
	}

	private int dfs(int[] nums, int left, int right, Integer[][] memo)
	{
		if (left >= right)
		{
			return 0;
		}

		if (memo[left][right] != null)
		{
			return memo[left][right];
		}

		memo[left][right] = 0;
		for (int i = left + 1; i < right; i++)
		{
			memo[left][right] = Math.max(memo[left][right],
				nums[left] * nums[i] * nums[right] + dfs(nums, left, i, memo) + dfs(nums, i, right, memo));
		}

		return memo[left][right];
	}

	public static void main(String[] args)
	{
		System.out.println(new BurstBalloons().maxCoins(new int[]{3, 1, 5, 8}));
		System.out.println(new BurstBalloons().maxCoins(new int[]{8, 3, 4, 3, 5, 0, 5, 6, 6, 2, 8, 5, 6, 2, 3, 8, 3, 5, 1, 0, 2}));
	}
}
