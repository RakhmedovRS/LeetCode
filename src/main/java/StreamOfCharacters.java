import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 23-Aug-20
 */
@LeetCode(id = 1032, name = "Stream of Characters", url = "https://leetcode.com/problems/stream-of-characters/")
public class StreamOfCharacters
{
	class StreamChecker
	{
		class TrieNode
		{
			TrieNode[] child = new TrieNode[26];
			boolean end = false;
		}

		private void addWord(TrieNode root, String word)
		{
			TrieNode current = root;
			for (char ch : word.toCharArray())
			{
				if (current.child[ch - 'a'] == null)
				{
					current.child[ch - 'a'] = new TrieNode();
				}
				current = current.child[ch - 'a'];
			}
			current.end = true;
		}

		TrieNode root;
		LinkedList<TrieNode> pointers;

		public StreamChecker(String[] words)
		{
			root = new TrieNode();
			pointers = new LinkedList<>();
			for (String word : words)
			{
				addWord(root, word);
			}
		}

		public boolean query(char letter)
		{
			boolean contains = false;
			int size = pointers.size();
			while (size-- > 0)
			{
				TrieNode temp = pointers.removeFirst();
				temp = temp.child[letter - 'a'];
				if (temp != null)
				{
					pointers.addLast(temp);
					if (temp.end)
					{
						contains = true;
					}
				}
			}

			if (root.child[letter - 'a'] != null)
			{
				pointers.addLast(root.child[letter - 'a']);
				if (root.child[letter - 'a'].end)
				{
					contains = true;
				}
			}

			return contains;
		}
	}
}
