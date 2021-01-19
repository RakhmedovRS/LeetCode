import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 1/19/2021
 */
@LeetCode(
	id = 320,
	name = "Generalized Abbreviation",
	url = "https://leetcode.com/problems/generalized-abbreviation/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class GeneralizedAbbreviation
{
	public List<String> generateAbbreviations(String word)
	{
		Map<Integer, List<String>> memo = new HashMap<>();
		return dfs(0, word.toCharArray(), memo);
	}

	private List<String> dfs(int pos, char[] chars, Map<Integer, List<String>> memo)
	{
		if (pos == chars.length)
		{
			return Collections.singletonList("");
		}

		if (memo.containsKey(pos))
		{
			return memo.get(pos);
		}

		List<String> result = new ArrayList<>();
		List<String> next;
		for (int count = 1; pos + count <= chars.length; count++)
		{
			next = dfs(pos + count, chars, memo);
			for (String str : next)
			{
				if (str.isEmpty() || Character.isLetter(str.charAt(0)))
				{
					result.add(count + str);
				}
				if (str.isEmpty() || Character.isDigit(str.charAt(0)))
				{
					result.add(String.valueOf(chars, pos, count) + str);
				}
			}
		}

		memo.put(pos, result);
		return result;
	}
}
