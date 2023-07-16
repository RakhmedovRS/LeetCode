package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/7/2021
 */
@LeetCode(
		id = 1297,
		name = "Maximum Number of Occurrences of a Substring",
		url = "https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumNumberOfOccurrencesOfSubstring
{
	class Trie
	{
		Trie[] children = new Trie[26];
		int count;
	}

	public int maxFreq(String s, int maxLetters, int minSize, int maxSize)
	{
		int count;
		int[] table;
		int maxFreq = 0;
		Trie root;
		char[] chars = s.toCharArray();
		for (int size = minSize; size <= maxSize; size++)
		{
			table = new int[26];
			root = new Trie();
			if (size > chars.length)
			{
				break;
			}

			int left = 0;
			int right = 0;
			while (right < chars.length)
			{
				table[chars[right] - 'a']++;
				if (right - left >= size - 1)
				{
					if (right - left > size - 1)
					{
						table[chars[left++] - 'a']--;
					}

					if (isValidSub(table, maxLetters))
					{
						count = addToTrie(root, left, right, chars);
						maxFreq = Math.max(maxFreq, count);
					}
				}
				right++;
			}
		}

		return maxFreq;
	}

	private boolean isValidSub(int[] table, int maxLetters)
	{
		for (int c : table)
		{
			if (c != 0)
			{
				maxLetters--;
			}
		}
		return maxLetters >= 0;
	}

	private int addToTrie(Trie root, int startPos, int endPos, char[] chars)
	{
		char ch;
		while (startPos <= endPos)
		{
			ch = chars[startPos++];
			if (root.children[ch - 'a'] == null)
			{
				root.children[ch - 'a'] = new Trie();
			}
			root = root.children[ch - 'a'];
		}

		root.count++;

		return root.count;
	}

	public static void main(String[] args)
	{
		MaximumNumberOfOccurrencesOfSubstring clazz = new MaximumNumberOfOccurrencesOfSubstring();
		System.out.println(clazz.maxFreq("abcde", 2, 3, 3));
		System.out.println(clazz.maxFreq("aabcabcab", 2, 2, 3));
		System.out.println(clazz.maxFreq("aaaa", 1, 3, 3));
		System.out.println(clazz.maxFreq("aababcaab", 2, 3, 4));
	}
}
