import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 11/15/2020
 */
@LeetCode(
	id = 1657,
	name = "Determine if Two Strings Are Close",
	url = "https://leetcode.com/problems/determine-if-two-strings-are-close/",
	difficulty = Difficulty.MEDIUM
)
public class DetermineIfTwoStringsAreClose
{
	public boolean closeStrings(String word1, String word2)
	{
		if (word1.length() != word2.length())
		{
			return false;
		}

		char[] w1Chars = word1.toCharArray();
		int[] w1Memo = new int[26];
		for (char ch : w1Chars)
		{
			w1Memo[ch - 'a']++;
		}

		char[] w2Chars = word2.toCharArray();
		int[] w2Memo = new int[26];
		for (char ch : w2Chars)
		{
			w2Memo[ch - 'a']++;
		}

		for (int i = 0; i < 26; i++)
		{
			if ((w1Memo[i] == 0 && w2Memo[i] != 0) || (w1Memo[i] != 0 && w2Memo[i] == 0))
			{
				return false;
			}
		}

		Arrays.sort(w1Memo);
		Arrays.sort(w2Memo);
		for (int i = 0; i < 26; i++)
		{
			if (w1Memo[i] != w2Memo[i])
			{
				return false;
			}
		}

		return true;
	}
}
