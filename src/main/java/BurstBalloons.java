import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 23-May-20
 */
@LeetCode(id = 312, name = "Burst Balloons", url = "https://leetcode.com/problems/burst-balloons/")
public class BurstBalloons
{
	public int maxCoins(int[] numbers)
	{
		return dfs(numbers, 0, numbers.length - 1, new Integer[numbers.length][numbers.length]);
	}

	private int dfs(int[] numbers, int left, int right, Integer[][] memo)
	{
		if (left > right)
		{
			return 0;
		}

		if (memo[left][right] != null)
		{
			return memo[left][right];
		}

		memo[left][right] = 0;
		for (int middle = left; middle <= right; middle++)
		{
			memo[left][right] = Math.max(memo[left][right], dfs(numbers, left, middle - 1, memo)
				+ getNeighbor(numbers, left - 1) * numbers[middle] * getNeighbor(numbers, right + 1)
				+ dfs(numbers, middle + 1, right, memo));
		}

		return memo[left][right];
	}

	private int getNeighbor(int[] numbers, int index)
	{
		if (index < 0 || index == numbers.length)
		{
			return 1;
		}

		return numbers[index];
	}

	public static void main(String[] args)
	{
		System.out.println(new BurstBalloons().maxCoins(new int[]{3, 1, 5, 8}));
		System.out.println(new BurstBalloons().maxCoins(new int[]{8, 3, 4, 3, 5, 0, 5, 6, 6, 2, 8, 5, 6, 2, 3, 8, 3, 5, 1, 0, 2}));
	}
}
