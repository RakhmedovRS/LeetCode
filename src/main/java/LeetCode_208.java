import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 07-Feb-20
 */
public class LeetCode_208
{
	class TrieNode
	{
		private Map<Character, TrieNode> children;
		private boolean isEnd;

		public TrieNode()
		{
			children = new HashMap<>();
		}

		public boolean containsKey(char ch)
		{
			return children.containsKey(ch);
		}

		public TrieNode get(char ch)
		{
			return children.get(ch);
		}

		public void put(char ch, TrieNode node)
		{
			children.put(ch, node);
		}

		public void setEnd()
		{
			isEnd = true;
		}

		public boolean isEnd()
		{
			return isEnd;
		}
	}

	public class Trie
	{
		TrieNode root;

		public Trie()
		{
			root = new TrieNode();
		}

		public void insert(String word)
		{
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++)
			{
				char currentChar = word.charAt(i);
				if (!node.containsKey(currentChar))
				{
					node.put(currentChar, new TrieNode());
				}
				node = node.get(currentChar);
			}
			node.setEnd();
		}

		private TrieNode searchPrefix(String word)
		{
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++)
			{
				char curLetter = word.charAt(i);
				if (node.containsKey(curLetter))
				{
					node = node.get(curLetter);
				}
				else
				{
					return null;
				}
			}
			return node;
		}

		public boolean search(String word)
		{
			TrieNode node = searchPrefix(word);
			return node != null && node.isEnd();
		}

		public boolean startsWith(String prefix)
		{
			TrieNode node = searchPrefix(prefix);
			return node != null;
		}
	}
}
