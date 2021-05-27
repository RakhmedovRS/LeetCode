package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 25-Jun-20
 */
@LeetCode(
	id = 318,
	name = "Maximum Product of Word Lengths",
	url = "https://leetcode.com/problems/maximum-product-of-word-lengths/",
	difficulty = Difficulty.MEDIUM
)
public class MaximumProductOfWordLengths
{
	public int maxProduct(String[] words)
	{
		int max = 0;
		boolean[][] tables = new boolean[words.length][];
		for (int i = 0; i < words.length; i++)
		{
			tables[i] = buildTable(words[i]);
		}

		for (int i = 0; i < words.length; i++)
		{
			for (int j = i + 1; j < words.length; j++)
			{
				if (!isIntersect(tables[i], tables[j]))
				{
					max = Math.max(max, words[i].length() * words[j].length());
				}
			}
		}

		return max;
	}

	private boolean[] buildTable(String string)
	{
		boolean[] table = new boolean[26];
		for (char ch : string.toCharArray())
		{
			table[ch - 'a'] = true;
		}

		return table;
	}

	private boolean isIntersect(boolean[] a, boolean[] b)
	{
		for (int i = 0; i < a.length; i++)
		{
			if (a[i] && b[i])
			{
				return true;
			}
		}

		return false;
	}
}
