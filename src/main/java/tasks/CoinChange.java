package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 07-Apr-20
 */
@LeetCode(
	id = 322,
	name = "Coin Change",
	url = "https://leetcode.com/problems/coin-change/",
	difficulty = Difficulty.MEDIUM
)
public class CoinChange
{
	public int coinChange(int[] coins, int amount)
	{
		int[] memo = new int[amount + 1];
		Arrays.fill(memo, Integer.MAX_VALUE);
		memo[0] = 0;

		for (long i = 0; i < memo.length; i++)
		{
			for (int coin : coins)
			{
				if (memo[(int) i] != Integer.MAX_VALUE && i + coin < memo.length && memo[(int) i] + 1 < memo[(int) i + coin])
				{
					memo[(int) i + coin] = memo[(int) i] + 1;
				}
			}
		}

		return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
	}

	public static void main(String[] args)
	{
		System.out.println(new CoinChange().coinChange(new int[]{186, 419, 83, 408}, 6249));
		System.out.println(new CoinChange().coinChange(new int[]{1, 2, 5}, 11));
	}
}
