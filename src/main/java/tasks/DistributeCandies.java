package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 1/5/2021
 */
@LeetCode(
		id = 575,
		name = "Distribute Candies",
		url = "https://leetcode.com/problems/distribute-candies/",
		difficulty = Difficulty.EASY,
		premium = true
)
public class DistributeCandies
{
	public int distributeCandies(int[] candyTypes)
	{
		Set<Integer> set = new HashSet<>(candyTypes.length * 3);
		for (int candyType : candyTypes)
		{
			set.add(candyType);
		}

		return Math.min(candyTypes.length / 2, set.size());
	}
}
