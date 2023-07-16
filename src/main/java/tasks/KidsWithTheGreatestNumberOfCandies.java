package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 02-Jun-20
 */
@LeetCode(
		id = 1431,
		name = "Kids With the Greatest Number of Candies",
		url = "https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/",
		difficulty = Difficulty.EASY
)
public class KidsWithTheGreatestNumberOfCandies
{
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies)
	{
		List<Boolean> answer = new ArrayList<>();
		int max = 0;
		for (int candy : candies)
		{
			if (candy > max)
			{
				max = candy;
			}
		}

		for (int candy : candies)
		{
			answer.add(candy + extraCandies >= max);
		}

		return answer;
	}
}
