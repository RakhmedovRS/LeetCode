import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 1/2/2021
 */
@LeetCode(
	id = 1698,
	name = "Number of Distinct Substrings in a String",
	url = "https://leetcode.com/problems/number-of-distinct-substrings-in-a-string/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class NumberOfDistinctSubstringsInString
{
	public int countDistinct(String s)
	{
		Set<String> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++)
		{
			for (int j = i; j < s.length(); j++)
			{
				set.add(s.substring(i, j + 1));
			}
		}

		return set.size();
	}
}
