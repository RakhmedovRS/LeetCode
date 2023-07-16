package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/19/2020
 */
@LeetCode(
		id = 1554,
		name = "Strings Differ by One Character",
		url = "https://leetcode.com/problems/strings-differ-by-one-character/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class StringsDifferByOneCharacter
{
	class Trie
	{
		Trie[] children = new Trie[26];
	}

	public boolean differByOne(String[] dict)
	{
		Trie root = new Trie();

		char[] word;
		for (int i = 0; i < dict.length; i++)
		{
			word = dict[i].toCharArray();
			if (findWord(root, false, word, 0))
			{
				return true;
			}
			else
			{
				addToTrie(root, word);
			}
		}

		return false;
	}

	private boolean findWord(Trie root, boolean seenMismatch, char[] word, int wordPos)
	{
		if (wordPos == word.length)
		{
			return true;
		}

		if (root.children[word[wordPos] - 'a'] == null)
		{
			if (!seenMismatch)
			{
				for (Trie child : root.children)
				{
					if (child != null && findWord(child, true, word, wordPos + 1))
					{
						return true;
					}
				}
			}
			return false;
		}
		else
		{
			if (findWord(root.children[word[wordPos] - 'a'], seenMismatch, word, wordPos + 1))
			{
				return true;
			}
			else if (!seenMismatch)
			{
				for (Trie child : root.children)
				{
					if (child != null && findWord(child, true, word, wordPos + 1))
					{
						return true;
					}
				}
			}

			return false;
		}
	}

	private void addToTrie(Trie root, char[] word)
	{
		for (char ch : word)
		{
			if (root.children[ch - 'a'] == null)
			{
				root.children[ch - 'a'] = new Trie();
			}

			root = root.children[ch - 'a'];
		}
	}

	public static void main(String[] args)
	{
		System.out.println(new StringsDifferByOneCharacter().differByOne(new String[]{"abcde", "abaaa", "aaade"}));
		System.out.println(new StringsDifferByOneCharacter().differByOne(new String[]{"abcd", "cccc", "abyd", "abab"}));
		System.out.println(new StringsDifferByOneCharacter().differByOne(new String[]{"ab", "cd", "yz"}));
		System.out.println(new StringsDifferByOneCharacter().differByOne(new String[]{"abcd", "acbd", "aacd"}));
	}
}
