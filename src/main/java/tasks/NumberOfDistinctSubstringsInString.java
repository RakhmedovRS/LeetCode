package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 1/2/2021
 */
@LeetCode(
	id = 1698,
	name = "Number of Distinct Substrings in a String",
	url = "https://leetcode.com/problems/number-of-distinct-substrings-in-a-string/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class NumberOfDistinctSubstringsInString
{
	class Trie
	{
		Trie[] children = new Trie[26];
	}

	public int countDistinct(String s)
	{
		Trie root = new Trie();
		Trie current;
		int count = 0;
		for (int i = 0; i < s.length(); i++)
		{
			current = root;
			for (int j = i; j < s.length(); j++)
			{

				if (current.children[s.charAt(j) - 'a'] == null)
				{
					current.children[s.charAt(j) - 'a'] = new Trie();
					count++;
				}

				current = current.children[s.charAt(j) - 'a'];
			}
		}

		return count;
	}
}
