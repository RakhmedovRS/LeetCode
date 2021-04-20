package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author RakhmedovRS
 * @created 11/19/2020
 */
@LeetCode(
	id = 846,
	name = "Hand of Straights",
	url = "https://leetcode.com/problems/hand-of-straights/",
	difficulty = Difficulty.MEDIUM
)
public class HandOfStraights
{
	public boolean isNStraightHand(int[] hand, int W)
	{
		TreeMap<Integer, Integer> handToCount = new TreeMap<>();
		for (int h : hand)
		{
			handToCount.put(h, handToCount.getOrDefault(h, 0) + 1);
		}
		while (!handToCount.isEmpty())
		{
			int count = 1;
			Map.Entry<Integer, Integer> entry = handToCount.pollFirstEntry();
			int current = entry.getKey();
			if (entry.getValue() > 1)
			{
				handToCount.put(entry.getKey(), entry.getValue() - 1);
			}

			while (count < W && !handToCount.isEmpty())
			{
				int numbersOfKeys = handToCount.getOrDefault(++current, 0);
				if (numbersOfKeys == 1)
				{
					handToCount.remove(current);
				}
				else if (numbersOfKeys > 1)
				{
					handToCount.put(current, handToCount.get(current) - 1);
				}
				else
				{
					break;
				}
				count++;
			}

			if (count != W)
			{
				return false;
			}
		}

		return true;
	}
}
