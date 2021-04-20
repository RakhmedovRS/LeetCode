package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/8/2020
 */
@LeetCode(id = 1647, name = "Minimum Deletions to Make Character Frequencies Unique", url = "https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/")
public class MinimumDeletionsToMakeCharacterFrequenciesUnique
{
	public int minDeletions(String s)
	{
		int[] memo = new int[26];
		for (char ch : s.toCharArray())
		{
			memo[ch - 'a']++;
		}

		int deletions = 0;
		boolean[] table = new boolean[10_001];
		for (int count : memo)
		{
			while (table[count] && count > 0)
			{
				count--;
				deletions++;
			}

			table[count] = true;
		}

		return deletions;
	}
}
