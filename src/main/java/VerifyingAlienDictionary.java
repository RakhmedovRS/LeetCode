import common.LeetCode;

import java.util.Comparator;

/**
 * @author RakhmedovRS
 * @created 21-Jul-20
 */
@LeetCode(id = 953, name = "Verifying an Alien Dictionary", url = "https://leetcode.com/problems/verifying-an-alien-dictionary/")
public class VerifyingAlienDictionary
{
	public boolean isAlienSorted(String[] words, String order)
	{
		int[] positions = new int[26];
		for (int i = 0; i < order.length(); i++)
		{
			positions[order.charAt(i) - 'a'] = i;
		}

		Comparator<String> comparator = (word1, word2) ->
		{
			int word1Pos = 0;
			int word2Pos = 0;
			while (word1Pos < word1.length() && word2Pos < word2.length())
			{
				int left = positions[word1.charAt(word1Pos++) - 'a'];
				int right = positions[word2.charAt(word2Pos++) - 'a'];
				if (left < right)
				{
					return -1;
				}
				else if (left > right)
				{
					return 1;
				}
			}

			return word1Pos == word1.length() && word2Pos == word2.length() ? 0 : word1Pos == word1.length() ? -1 : 1;
		};

		for (int i = 1; i < words.length; i++)
		{
			if (comparator.compare(words[i - 1], words[i]) > 0)
			{
				return false;
			}
		}

		return true;
	}
}
