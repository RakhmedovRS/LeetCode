package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 11/27/2021
 */
@LeetCode(
	id = 2085,
	name = "Count Common Words With One Occurrence",
	url = "https://leetcode.com/problems/count-common-words-with-one-occurrence/",
	difficulty = Difficulty.EASY
)
public class CountCommonWordsWithOneOccurrence
{
	public int countWords(String[] words1, String[] words2)
	{
		int count = 0;
		Map<String, Integer> a = count(words1);
		Map<String, Integer> b = count(words2);
		for (Map.Entry<String, Integer> entry : a.entrySet())
		{
			if (entry.getValue() == 1 && b.getOrDefault(entry.getKey(), 0) == 1)
			{
				count++;
			}
		}

		return count;
	}

	private Map<String, Integer> count(String[] words)
	{
		Map<String, Integer> map = new HashMap<>();
		for (String word : words)
		{
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		return map;
	}
}
