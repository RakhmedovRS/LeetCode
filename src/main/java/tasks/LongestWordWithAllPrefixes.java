package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 5/13/2021
 */
@LeetCode(
		id = 1858,
		name = "Longest Word With All Prefixes",
		url = "https://leetcode.com/problems/longest-word-with-all-prefixes/",
		difficulty = Difficulty.MEDIUM
)
public class LongestWordWithAllPrefixes
{
	class Trie
	{
		class Node
		{
			Node[] children = new Node[26];
			boolean seen;
		}

		private Node root;

		public Trie()
		{
			root = new Node();
			root.seen = true;
		}

		private boolean addWord(String s)
		{
			Node current = root;

			char ch;
			for (int i = 0; i < s.length(); i++)
			{
				ch = s.charAt(i);
				if (current.children[ch - 'a'] == null)
				{
					current.children[ch - 'a'] = new Node();
					if (current.seen && i == s.length() - 1)
					{
						current.children[ch - 'a'].seen = true;
					}
				}
				current = current.children[ch - 'a'];
			}

			return current.seen;
		}
	}

	public String longestWord(String[] words)
	{
		Arrays.sort(words, (a, b) ->
		{
			if (a.length() == b.length())
			{
				return a.compareTo(b);
			}

			return a.length() - b.length();
		});

		Trie trie = new Trie();

		String answer = "";
		for (String word : words)
		{
			if (trie.addWord(word))
			{
				if (word.length() > answer.length())
				{
					answer = word;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args)
	{
		LongestWordWithAllPrefixes clazz = new LongestWordWithAllPrefixes();

		System.out.println(clazz.longestWord(new String[]{"abc", "bc", "ab", "qwe"}));
		System.out.println(clazz.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
	}
}
