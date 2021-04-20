package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 25-Jun-20
 */
@LeetCode(id = 318, name = "Maximum Product of Word Lengths", url = "https://leetcode.com/problems/maximum-product-of-word-lengths/")
public class MaximumProductOfWordLengths
{
	public int maxProduct(String[] words)
	{
		int[][] tables = new int[words.length][];
		for (int i = 0; i < words.length; i++)
		{
			tables[i] = createTable(words[i]);
		}

		int max = 0;
		for (int i = 0; i < tables.length - 1; i++)
		{
			for (int j = i + 1; j < tables.length; j++)
			{
				if (!containsSameChars(tables[i], tables[j]))
				{
					max = Math.max(max, words[i].length() * words[j].length());
				}
			}
		}

		return max;
	}

	private int[] createTable(String word)
	{
		int[] table = new int[26];
		for (char ch : word.toCharArray())
		{
			table[ch - 'a']++;
		}

		return table;
	}

	private boolean containsSameChars(int[] table1, int[] table2)
	{
		for (int i = 0; i < 26; i++)
		{
			if (table1[i] > 0 && table2[i] > 0)
			{
				return true;
			}
		}

		return false;
	}
}
