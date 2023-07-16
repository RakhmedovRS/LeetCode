package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 07-Jun-20
 */
@LeetCode(
		id = 518,
		name = "Coin Change 2",
		url = "https://leetcode.com/problems/coin-change-2/",
		difficulty = Difficulty.MEDIUM
)
public class CoinChange2
{
	public int change(int amount, int[] coins)
	{
		int[][] memo = new int[coins.length + 1][amount + 1];
		for (int[] row : memo)
		{
			row[0] = 1;
		}

		for (int row = 1; row < memo.length; row++)
		{
			for (int column = 1; column < memo[row].length; column++)
			{
				memo[row][column] = memo[row - 1][column] + (column - coins[row - 1] >= 0 ? memo[row][column - coins[row - 1]] : 0);
			}
		}

		return memo[coins.length][amount];
	}

	public static void main(String[] args)
	{
		System.out.println(new CoinChange2().change(5, new int[]{1, 2, 5}));
	}
}
