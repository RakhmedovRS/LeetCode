package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 14-Aug-20
 */

@LeetCode(id = 890, name = "Find and Replace Pattern", url = "https://leetcode.com/problems/find-and-replace-pattern/")
public class FindAndReplacePattern
{
	public List<String> findAndReplacePattern(String[] words, String pattern)
	{
		List<String> answer = new ArrayList<>();
		for (String word : words)
		{
			if (word.length() == pattern.length() && replacePossible(word, pattern))
			{
				answer.add(word);
			}
		}

		return answer;
	}

	private boolean replacePossible(String word, String pattern)
	{
		Map<Character, Character> wordToPattern = new HashMap<>();
		Map<Character, Character> patternToWord = new HashMap<>();
		for (int i = 0; i < word.length(); i++)
		{
			char wChar = word.charAt(i);
			char pChar = pattern.charAt(i);
			if (!wordToPattern.containsKey(wChar))
			{
				wordToPattern.put(wChar, pChar);
			}
			if (!patternToWord.containsKey(pChar))
			{
				patternToWord.put(pChar, wChar);
			}

			if (wordToPattern.get(wChar) != pChar || patternToWord.get(pChar) != wChar)
			{
				return false;
			}
		}

		return true;
	}
}
