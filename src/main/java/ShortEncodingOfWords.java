import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 1/6/2021
 */
@LeetCode(
	id = 820,
	name = "Short Encoding of Words",
	url = "https://leetcode.com/problems/short-encoding-of-words/",
	difficulty = Difficulty.MEDIUM

)
public class ShortEncodingOfWords
{
	class Trie
	{
		Trie[] children = new Trie[26];
	}

	public int minimumLengthEncoding(String[] words)
	{
		Trie[] roots = new Trie[8];
		for (int i = 0; i < 8; i++)
		{
			roots[i] = new Trie();
		}

		Arrays.sort(words, (a, b) ->
		{
			if (a.length() == b.length())
			{
				return b.compareTo(a);
			}
			return b.length() - a.length();
		});

		int length = 0;
		for (String word : words)
		{
			if (!contains(roots[word.length()], word, 0))
			{
				length += word.length() + 1;
			}

			for (int i = 1; i < word.length(); i++)
			{
				contains(roots[word.length() - i], word, i);
			}
		}

		return length;
	}

	public boolean contains(Trie root, String word, int pos)
	{
		boolean foundMismatch = false;
		char ch;
		while (pos < word.length())
		{
			ch = word.charAt(pos++);
			if (root.children[ch - 'a'] == null)
			{
				root.children[ch - 'a'] = new Trie();
				foundMismatch = true;
			}
			root = root.children[ch - 'a'];
		}

		return !foundMismatch;
	}

	public static void main(String[] args)
	{
		ShortEncodingOfWords clazz = new ShortEncodingOfWords();

		System.out.println(clazz.minimumLengthEncoding(new String[]{"time", "atime", "btime"}));
	}
}
