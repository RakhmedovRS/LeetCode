import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 07-Feb-20
 */
@LeetCode(id = 208, name = "Implement Trie (Prefix Tree)", url = "https://leetcode.com/problems/implement-trie-prefix-tree/")
public class PrefixTree
{
	class TrieNode
	{
		private TrieNode[] children;
		private boolean isEnd;

		public TrieNode()
		{
			children = new TrieNode[26];
		}

		public TrieNode getChild(char ch)
		{
			return children[ch - 'a'];
		}

		public void setChildren(char ch, TrieNode node)
		{
			children[ch - 'a'] = node;
		}

		public boolean isEnd()
		{
			return isEnd;
		}

		public void setEnd()
		{
			this.isEnd = true;
		}
	}

	class Trie
	{
		TrieNode root;

		public Trie()
		{
			root = new TrieNode();
		}

		public void insert(String word)
		{
			TrieNode current = root;
			for (char ch : word.toCharArray())
			{
				if (current.getChild(ch) == null)
				{
					current.setChildren(ch, new TrieNode());
				}
				current = current.getChild(ch);
			}
			current.setEnd();
		}

		public boolean search(String word)
		{
			TrieNode current = root;
			for (char ch : word.toCharArray())
			{
				current = current.getChild(ch);
				if (current == null)
				{
					return false;
				}
			}

			return current.isEnd();
		}

		public boolean startsWith(String prefix)
		{
			TrieNode current = root;
			for (char ch : prefix.toCharArray())
			{
				current = current.getChild(ch);
				if (current == null)
				{
					return false;
				}
			}
			return true;
		}
	}
}
