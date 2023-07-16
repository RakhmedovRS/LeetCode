package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 1/10/2023
 */
@LeetCode(
		id = 2531,
		name = "Make Number of Distinct Characters Equal",
		url = "https://leetcode.com/problems/make-number-of-distinct-characters-equal/",
		difficulty = Difficulty.MEDIUM
)
public class MakeNumberOfDistinctCharactersEqual
{
	public boolean isItPossible(String word1, String word2)
	{
		int[] freq1 = createCharFrequencyTable(word1);
		int[] freq2 = createCharFrequencyTable(word2);

		for (int a = 0; a < freq1.length; a++)
		{
			if (freq1[a] > 0)
			{
				freq1[a]--;
				for (int b = 0; b < freq2.length; b++)
				{
					if (freq2[b] > 0)
					{
						freq2[a]++;
						freq1[b]++;
						freq2[b]--;
						if (distinct(freq1) == distinct(freq2))
						{
							return true;
						}
						freq2[a]--;
						freq1[b]--;
						freq2[b]++;
					}
				}
				freq1[a]++;
			}
		}

		for (int b = 0; b < freq2.length; b++)
		{
			if (freq2[b] > 0)
			{
				freq2[b]--;
				for (int a = 0; a < freq1.length; a++)
				{
					if (freq1[a] > 0)
					{
						freq1[b]++;
						freq2[a]++;
						freq1[a]--;
						if (distinct(freq1) == distinct(freq2))
						{
							return true;
						}
						freq1[b]--;
						freq2[a]--;
						freq1[a]++;
					}
				}
				freq2[b]++;
			}
		}

		return false;
	}

	int distinct(int[] freq)
	{
		int c = 0;
		for (int f : freq)
		{
			if (f >= 1)
			{
				c++;
			}
		}

		return c;
	}

	public int[] createCharFrequencyTable(String word)
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
}
