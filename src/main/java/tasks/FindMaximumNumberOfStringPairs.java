package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 6/25/2023
 */
@LeetCode(
		id = 2744,
		name = "Find Maximum Number of String Pairs",
		url = "https://leetcode.com/problems/find-maximum-number-of-string-pairs/description/",
		difficulty = Difficulty.EASY
)
public class FindMaximumNumberOfStringPairs
{
	public int maximumNumberOfStringPairs(String[] words)
	{
		Set<String> rev = new HashSet<>();
		int count = 0;
		for (String w : words)
		{
			String r = new StringBuilder(w).reverse().toString();
			if (rev.contains(w))
			{
				count++;
				rev.remove(w);
			}
			else
			{
				rev.add(r);
			}
		}

		return count;
	}
}
