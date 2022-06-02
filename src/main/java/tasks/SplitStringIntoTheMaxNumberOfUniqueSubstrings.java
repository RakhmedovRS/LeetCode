package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 20-Sep-20
 */
@LeetCode(
	id = 1593,
	name = "Split a String Into the Max Number of Unique Substrings",
	url = "https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/",
	difficulty = Difficulty.EASY
)
public class SplitStringIntoTheMaxNumberOfUniqueSubstrings
{
	public int maxUniqueSplit(String s)
	{
		return dfs(s, 0, new HashSet<>());
	}

	private int dfs(String s, int start, Set<String> set)
	{
		if (start >= s.length())
		{
			return set.size();
		}

		String sub;
		int max = 0;
		for (int i = start + 1; i <= s.length(); i++)
		{
			sub = s.substring(start, i);
			if (set.add(sub))
			{
				max = Math.max(max, dfs(s, i, set));
				set.remove(sub);
			}
		}
		return max;
	}
}
