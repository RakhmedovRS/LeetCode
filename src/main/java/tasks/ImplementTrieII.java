package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 3/25/2021
 */
@LeetCode(
		id = 1804,
		name = "Implement Trie II (Prefix Tree)",
		url = "https://leetcode.com/problems/implement-trie-ii-prefix-tree/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class ImplementTrieII
{
	class Node
	{
		Node[] children = new Node[26];
		int count;
		int end;
	}

	class Trie
	{
		private Node root;

		public Trie()
		{
			root = new Node();
		}

		public void insert(String word)
		{
			Node current = root;
			int pos;
			for (char ch : word.toCharArray())
			{
				pos = ch - 'a';
				if (current.children[pos] == null)
				{
					current.children[pos] = new Node();
				}

				current = current.children[pos];
				current.count++;
			}

			current.end++;
		}

		public int countWordsEqualTo(String word)
		{
			Node current = root;
			int pos;
			for (char ch : word.toCharArray())
			{
				pos = ch - 'a';
				if (current.children[pos] == null)
				{
					return 0;
				}

				current = current.children[pos];
			}

			return current.end;
		}

		public int countWordsStartingWith(String prefix)
		{
			Node current = root;
			int pos;
			for (char ch : prefix.toCharArray())
			{
				pos = ch - 'a';
				if (current.children[pos] == null)
				{
					return 0;
				}

				current = current.children[pos];
			}

			return current.count;
		}

		public void erase(String word)
		{
			Node current = root;
			int pos;
			for (char ch : word.toCharArray())
			{
				pos = ch - 'a';
				current = current.children[pos];
				current.count--;
			}

			current.end--;
		}
	}
}
