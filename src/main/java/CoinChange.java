import common.LeetCode;

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
		if (coins == null || coins.length == 0 || amount <= 0)
		{
			return 0;
		}

		Map<Integer, Integer> cache = new HashMap<>();
		return coinChange(coins, amount, cache);
	}

	private int coinChange(int[] coins, int amount, Map<Integer, Integer> cache)
	{
		if (amount <= 0)
		{
			return amount;
		}

		if (cache.containsKey(amount))
		{
			return cache.get(amount);
		}

		int min = Integer.MAX_VALUE;
		for (int coin : coins)
		{
			int result = coinChange(coins, amount - coin, cache);
			if (result >= 0 && result < min)
			{
				min = 1 + result;
			}
		}

		cache.put(amount, (min == Integer.MAX_VALUE) ? -1 : min);
		return cache.get(amount);
	}

	public static void main(String[] args)
	{
		System.out.println(new CoinChange().coinChange(new int[]{186, 419, 83, 408}, 6249));
		System.out.println(new CoinChange().coinChange(new int[]{1, 2, 5}, 11));
	}
}
