import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 10-May-20
 */
@LeetCode(id = 915, name = "Word Subsets", url = "https://leetcode.com/problems/word-subsets/")
public class WordSubsets
{
	public List<String> wordSubsets(String[] A, String[] B)
	{
		List<String> result = new ArrayList<>();
		if (A == null || A.length == 0 || B == null || B.length == 0)
		{
			return result;
		}

		int[] charsToCountB = fillMapB(B);
		for (String word : A)
		{
			boolean valid = true;
			int[] charsToCountA = fillMapA(word);
			for (int i = 0; i < 26; i++)
			{
				if (charsToCountB[i] > charsToCountA[i])
				{
					valid = false;
					break;
				}
			}

			if (valid)
			{
				result.add(word);
			}
		}


		return result;
	}

	private int[] fillMapA(String word)
	{
		int[] charsToCount = new int[26];
		for (char ch : word.toCharArray())
		{
			charsToCount[ch - 'a']++;
		}
		return charsToCount;
	}

	private int[] fillMapB(String[] words)
	{
		int[] result = new int[26];
		for (String word : words)
		{
			int[] temp = new int[26];
			for (char ch : word.toCharArray())
			{
				temp[ch- 'a']++;
			}

			for (int i = 0; i < 26; i++)
			{
				if (temp[i] > result[i])
				{
					result[i] = temp[i];
				}
			}
		}

		return result;
	}
}
