package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 03-Jul-20
 */
@LeetCode(
		id = 211,
		name = "Design Add and Search Words Data Structure",
		url = "https://leetcode.com/problems/add-and-search-word-data-structure-design/",
		difficulty = Difficulty.MEDIUM
)
public class DesignAddAndSearchWordsDataStructure
{
	class TrieNode
	{
		TrieNode[] child = new TrieNode[26];
		boolean isEnd = false;
	}

	class WordDictionary
	{
		TrieNode root;

		public WordDictionary()
		{
			root = new TrieNode();
		}

		public void addWord(String word)
		{
			TrieNode curr = root;
			for (char ch : word.toCharArray())
			{
				if (curr.child[ch - 'a'] == null)
				{
					curr.child[ch - 'a'] = new TrieNode();
				}
				curr = curr.child[ch - 'a'];
			}
			curr.isEnd = true;
		}

		public boolean search(String word)
		{
			return find(root, word.toCharArray(), 0);
		}

		private boolean find(TrieNode trieNode, char[] chars, int pos)
		{
			if (trieNode == null)
			{
				return false;
			}

			if (pos == chars.length)
			{
				return trieNode.isEnd;
			}

			if (chars[pos] == '.')
			{
				for (TrieNode node : trieNode.child)
				{
					if (find(node, chars, pos + 1))
					{
						return true;
					}
				}
				return false;
			}
			else if (trieNode.child[chars[pos] - 'a'] != null)
			{
				return find(trieNode.child[chars[pos] - 'a'], chars, pos + 1);
			}
			else
			{
				return false;
			}
		}
	}

	public static void main(String[] args)
	{
		WordDictionary dictionary = new DesignAddAndSearchWordsDataStructure().new WordDictionary();
		System.out.println(dictionary.search("a"));
		dictionary.addWord("bad");
		dictionary.addWord("dad");
		dictionary.addWord("mad");
		System.out.println(dictionary.search("pad"));
		System.out.println(dictionary.search("bad"));
		System.out.println(dictionary.search(".ad"));
		System.out.println(dictionary.search("b.."));
	}
}
