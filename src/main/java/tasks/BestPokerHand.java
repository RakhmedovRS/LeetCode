package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 7/23/2022
 */
@LeetCode(
	id = 2347,
	name = "Best Poker Hand",
	url = "https://leetcode.com/problems/best-poker-hand/",
	difficulty = Difficulty.EASY
)
public class BestPokerHand
{
	public String bestHand(int[] ranks, char[] suits)
	{
		if (suits[0] == suits[1] && suits[1] == suits[2] && suits[2] == suits[3] && suits[3] == suits[4])
		{
			return "Flush";
		}

		int[] r = new int[14];
		for (int rank : ranks)
		{
			r[rank]++;
		}

		boolean seenPair = false;
		for (int c : r)
		{
			if (c > 2)
			{
				return "Three of a Kind";
			}
			else if (c == 2)
			{
				seenPair = true;
			}
		}

		return seenPair ? "Pair" : "High Card";
	}
}
