package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 23-Aug-20
 */
@LeetCode(
	id = 1032,
	name = "Stream of Characters",
	url = "https://leetcode.com/problems/stream-of-characters/",
	difficulty = Difficulty.HARD
)
public class StreamOfCharacters
{
	class StreamChecker
	{
		class TrieNode
		{
			TrieNode[] child = new TrieNode[26];
			boolean end = false;
		}

		private TrieNode buildTrie(String[] words)
		{
			TrieNode root = new TrieNode();
			for (String word : words)
			{
				TrieNode current = root;
				for (int i = word.length() - 1; i>= 0; i--)
				{
					char ch = word.charAt(i);
					if (current.child[ch - 'a'] == null)
					{
						current.child[ch - 'a'] = new TrieNode();
					}
					current = current.child[ch - 'a'];
				}
				current.end = true;
			}
			return root;
		}

		TrieNode root;
		StringBuilder sb;

		public StreamChecker(String[] words)
		{
			root = buildTrie(words);
			sb = new StringBuilder();
		}

		public boolean query(char letter)
		{
			sb.append(letter);
			TrieNode current = root;
			for (int i = sb.length() - 1; i >= 0 && current != null; i--)
			{
				char ch = sb.charAt(i);
				current = current.child[ch - 'a'];
				if (current != null && current.end)
				{
					return true;
				}
			}

			return false;
		}
	}
}
