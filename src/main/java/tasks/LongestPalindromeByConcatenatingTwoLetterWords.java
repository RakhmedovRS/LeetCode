package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 1/8/2022
 */
@LeetCode(
		id = 2131,
		name = "Longest Palindrome by Concatenating Two Letter Words",
		url = "https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/",
		difficulty = Difficulty.MEDIUM
)
public class LongestPalindromeByConcatenatingTwoLetterWords
{
	public int longestPalindrome(String[] words)
	{
		Map<String, Integer> wordToCount = new HashMap<>();
		for (String word : words)
		{
			wordToCount.put(word, wordToCount.getOrDefault(word, 0) + 1);
		}

		int result = 0;
		Set<String> seen = new HashSet<>();
		for (String word : words)
		{
			char a = word.charAt(0);
			char b = word.charAt(1);
			String reversed = "" + b + a;

			if (a == b)
			{
				if (!seen.add(word))
				{
					result += 4;
					seen.remove(word);
				}
			}
			else if (wordToCount.containsKey(word) && wordToCount.containsKey(reversed))
			{
				result += 4;
				int count = wordToCount.remove(word);
				if (--count > 0)
				{
					wordToCount.put(word, count);
				}

				count = wordToCount.remove(reversed);
				if (--count > 0)
				{
					wordToCount.put(reversed, count);
				}
			}
		}

		if (!seen.isEmpty())
		{
			result += 2;
		}

		return result;
	}
}
