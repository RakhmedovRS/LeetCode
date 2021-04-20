package tasks;

import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 30-Jun-20
 */
@LeetCode(id = 914, name = "X of a Kind in a Deck of Cards", url = "https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/")
public class XOfKindInDeckOfCards
{
	public boolean hasGroupsSizeX(int[] deck)
	{
		Map<Integer, Integer> cardToCount = new HashMap<>();
		for (int card : deck)
		{
			cardToCount.put(card, cardToCount.getOrDefault(card, 0) + 1);
		}

		int gcd = 0;
		for (int count : cardToCount.values())
		{
			gcd = gcd == 0 ? count : gcd(gcd, count);
		}

		return gcd > 1;
	}

	private int gcd(int x, int y)
	{
		if (x == 0)
		{
			return y;
		}
		return gcd(y % x, x);
	}
}
