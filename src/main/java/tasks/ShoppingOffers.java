package tasks;

import common.LeetCode;

import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 9/28/2020
 */
@LeetCode(id = 638, name = "Shopping Offers", url = "https://leetcode.com/problems/shopping-offers/")
public class ShoppingOffers
{
	public int shoppingOffers(List<Integer> prices, List<List<Integer>> special, List<Integer> needs)
	{
		int[] needsMemo = new int[needs.size()];
		for (int i = 0; i < prices.size(); i++)
		{
			needsMemo[i] += needs.get(i);
		}

		int[] minPrice = new int[]{Integer.MAX_VALUE};
		dfs(prices, special, 0, needsMemo, 0, minPrice);
		return minPrice[0];
	}

	private void dfs(List<Integer> prices, List<List<Integer>> special, int specialPos, int[] needsMemo, int price, int[] minPrice)
	{
		if (boughtEverything(needsMemo))
		{
			minPrice[0] = Math.min(minPrice[0], price);
			return;
		}

		if (!stillCanBuy(needsMemo))
		{
			return;
		}

		int[] tempMemo;
		if (specialPos == special.size())
		{
			int normalPrice = price;
			tempMemo = Arrays.copyOfRange(needsMemo, 0, needsMemo.length);
			for (int i = 0; i < tempMemo.length; i++)
			{
				normalPrice += needsMemo[i] * prices.get(i);
				tempMemo[i] = 0;
			}
			dfs(prices, special, specialPos, tempMemo, normalPrice, minPrice);
			return;
		}

		dfs(prices, special, specialPos + 1, needsMemo, price, minPrice);

		int specialPrice = price + special.get(specialPos).get(special.get(specialPos).size() - 1);
		tempMemo = Arrays.copyOfRange(needsMemo, 0, needsMemo.length);
		for (int i = 0; i < special.get(specialPos).size() - 1; i++)
		{
			tempMemo[i] -= special.get(specialPos).get(i);
		}
		dfs(prices, special, specialPos, tempMemo, specialPrice, minPrice);
		dfs(prices, special, specialPos + 1, tempMemo, specialPrice, minPrice);

		int normalPrice = price;
		tempMemo = Arrays.copyOfRange(needsMemo, 0, needsMemo.length);
		for (int i = 0; i < tempMemo.length; i++)
		{
			normalPrice += needsMemo[i] * prices.get(i);
			tempMemo[i] = 0;
		}
		dfs(prices, special, specialPos, tempMemo, normalPrice, minPrice);
	}

	private boolean stillCanBuy(int[] needsMemo)
	{
		for (int value : needsMemo)
		{
			if (value < 0)
			{
				return false;
			}
		}
		return true;
	}

	private boolean boughtEverything(int[] needsMemo)
	{
		for (int value : needsMemo)
		{
			if (value != 0)
			{
				return false;
			}
		}
		return true;
	}
}
