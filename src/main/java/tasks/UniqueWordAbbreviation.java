package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 1/19/2021
 */
@LeetCode(
		id = 288,
		name = "Unique Word Abbreviation",
		url = "https://leetcode.com/problems/unique-word-abbreviation/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class UniqueWordAbbreviation
{
	class ValidWordAbbr
	{

		Map<String, Set<String>> map;

		public ValidWordAbbr(String[] dictionary)
		{
			map = new HashMap<>();
			String abbreviation;
			for (String word : dictionary)
			{
				abbreviation = createAbbreviation(word);
				map.putIfAbsent(abbreviation, new HashSet<>());
				map.get(abbreviation).add(word);
			}
		}

		public boolean isUnique(String word)
		{
			String abbreviation = createAbbreviation(word);
			if (!map.containsKey(abbreviation))
			{
				return true;
			}

			return map.get(abbreviation).contains(word) && map.get(abbreviation).size() == 1;
		}

		private String createAbbreviation(String word)
		{
			if (word.length() == 2)
			{
				return word;
			}
			else
			{
				return "" + word.charAt(0) + (word.length() - 2) + word.charAt(word.length() - 1);
			}
		}
	}
}
