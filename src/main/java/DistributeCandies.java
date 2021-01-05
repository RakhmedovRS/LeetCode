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
	public int distributeCandies(int[] candyType)
	{
		Set<Integer> set = new HashSet<>();
		for (int candy : candyType)
		{
			set.add(candy);
		}

		return Math.min(set.size(), candyType.length / 2);
	}
}
