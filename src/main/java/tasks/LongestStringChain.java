package tasks;

import common.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 02-Jul-20
 */
@LeetCode(id = 1048, name = "Longest String Chain", url = "https://leetcode.com/problems/longest-string-chain/")
public class LongestStringChain
{
	public int longestStrChain(String[] words)
	{
		if (words.length == 0)
		{
			return 0;
		}

		Arrays.sort(words, Comparator.comparingInt(String::length));
		Map<String, Integer> patternToCount = new HashMap<>(words.length * 3);
		int max = 0;
		for (String word : words)
		{
			for (int i = 0; i < word.length(); i++)
			{
				String newWord = word.substring(0, i) + word.substring(i + 1);
				if (patternToCount.containsKey(newWord))
				{
					patternToCount.put(word, patternToCount.get(newWord) + 1);
				}
			}

			if (!patternToCount.containsKey(word))
			{
				patternToCount.put(word, 1);
			}

			max = Math.max(max, patternToCount.get(word));
		}

		return max;
	}
}
