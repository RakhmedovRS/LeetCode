package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 14-Aug-20
 */

@LeetCode(
		id = 890,
		name = "Find and Replace Pattern",
		url = "https://leetcode.com/problems/find-and-replace-pattern/",
		difficulty = Difficulty.MEDIUM
)
public class FindAndReplacePattern
{
	public List<String> findAndReplacePattern(String[] words, String pattern)
	{
		List<String> answer = new ArrayList<>();
		for (String word : words)
		{
			if (isMatch(word, pattern))
			{
				answer.add(word);
			}
		}

		return answer;
	}

	private boolean isMatch(String word, String pattern)
	{
		if (word.length() != pattern.length())
		{
			return false;
		}

		boolean[] used = new boolean[26];
		Map<Character, Character> map = new HashMap<>();
		char wChar;
		char pChar;
		for (int i = 0; i < word.length(); i++)
		{
			wChar = word.charAt(i);
			pChar = pattern.charAt(i);

			if (!map.containsKey(pChar))
			{
				if (used[wChar - 'a'])
				{
					return false;
				}
				map.put(pChar, wChar);
				used[wChar - 'a'] = true;
			}
			else if (map.get(pChar) != wChar)
			{
				return false;
			}
		}

		return true;
	}
}
