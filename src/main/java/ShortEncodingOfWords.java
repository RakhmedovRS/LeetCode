import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

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
		Arrays.sort(words, Comparator.comparingInt(String::length));
		Trie root = new Trie();
		int len = 0;
		for (int i = words.length - 1; i >= 0; i--)
		{
			len += addToTrie(root, words[i]) ? words[i].length() + 1 : 0;
		}

		return len;
	}

	private boolean addToTrie(Trie root, String word)
	{
		boolean added = false;
		Trie current = root;
		int pos;
		for (int i = word.length() - 1; i >= 0; i--)
		{
			pos = word.charAt(i) - 'a';
			if (current.children[pos] == null)
			{
				added = true;
				current.children[pos] = new Trie();
			}

			current = current.children[pos];
		}
		return added;
	}

	public static void main(String[] args)
	{
		ShortEncodingOfWords clazz = new ShortEncodingOfWords();

		System.out.println(clazz.minimumLengthEncoding(new String[]{"time", "atime", "btime"}));
	}
}
