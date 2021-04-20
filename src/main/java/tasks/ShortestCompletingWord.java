package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 23-Jun-20
 */
@LeetCode(id = 748, name = "Shortest Completing Word", url = "https://leetcode.com/problems/shortest-completing-word/")
public class ShortestCompletingWord
{
	public String shortestCompletingWord(String licensePlate, String[] words)
	{
		int[] pattern = createTable(licensePlate);
		int minLength = Integer.MAX_VALUE;
		String answer = null;
		for (String word : words)
		{
			if (isMatch(pattern, createTable(word)))
			{
				if (word.length() < minLength)
				{
					minLength = word.length();
					answer = word;
				}
			}
		}

		return answer;
	}

	private int[] createTable(String word)
	{
		int[] pattern = new int[26];
		for (char ch : word.toCharArray())
		{
			if (Character.isAlphabetic(ch))
			{
				pattern[Character.toLowerCase(ch) - 'a']++;
			}
		}

		return pattern;
	}

	private boolean isMatch(int[] pattern, int[] wordTable)
	{
		for (int i = 0; i < 26; i++)
		{
			if (pattern[i] > wordTable[i])
			{
				return false;
			}
		}
		return true;
	}
}
