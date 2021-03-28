import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 3/28/2021
 */
@LeetCode(
	id = 1805,
	name = "Number of Different Integers in a String",
	url = "https://leetcode.com/problems/number-of-different-integers-in-a-string/",
	difficulty = Difficulty.EASY
)
public class NumberOfDifferentIntegersInString
{
	public int numDifferentIntegers(String word)
	{
		Set<Integer> set = new HashSet<>();
		Integer number = null;
		for (int i = 0; i < word.length(); i++)
		{
			if (Character.isDigit(word.charAt(i)))
			{
				number = number == null ? 0 : number;
				number *= 10;
				number += word.charAt(i) - '0';
			}
			else
			{
				if (number != null)
				{
					set.add(number);
					number = null;
				}
			}
		}

		if (number != null)
		{
			set.add(number);
		}

		return set.size();
	}
}
