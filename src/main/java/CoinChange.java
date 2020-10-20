import common.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 07-Apr-20
 */
@LeetCode(id = 322, name = "Coin Change", url = "https://leetcode.com/problems/coin-change/")
public class CoinChange
{
	public int coinChange(int[] coins, int amount)
	{
		int[] memo = new int[amount + 1];
		Arrays.fill(memo, Integer.MAX_VALUE);
		memo[0] = 0;
		for (int i = 1; i <= amount; i++)
		{
			for (int coin : coins)
			{
				if (i - coin >= 0 && memo[i - coin] != Integer.MAX_VALUE)
				{
					memo[i] = Math.min(memo[i], 1 + memo[i - coin]);
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
