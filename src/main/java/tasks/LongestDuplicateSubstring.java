package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 19-Jun-20
 */
@LeetCode(id = 1044, name = "Longest Duplicate Substring", url = "https://leetcode.com/problems/longest-duplicate-substring/")
public class LongestDuplicateSubstring
{
	private class TrieNode
	{
		private TrieNode[] next;
		private int i;
		private int depth;

		public TrieNode(int i, int depth)
		{
			this.i = i;
			this.depth = depth;
		}

		private boolean isLeaf()
		{
			return next == null;
		}
	}

	private String S;

	public String longestDupSubstring(String S)
	{
		this.S = S;
		int maxLo = 0, maxLength = 0;
		TrieNode root = new TrieNode(0, 0);
		for (int i = 1; i + maxLength < S.length(); i++)
		{
			int len = addNew(root, i);
			if (len > maxLength)
			{
				maxLength = len;
				maxLo = i;
			}
		}
		return S.substring(maxLo, maxLo + maxLength);
	}

	private int getIndex(int i, int depth)
	{
		return S.charAt(i + depth) - 'a';
	}

	private int addNew(TrieNode node, int i)
	{
		int depth = node.depth;
		if (i + depth == S.length())
		{
			return depth;
		}
		if (node.isLeaf())
		{
			node.next = new TrieNode[26];
			node.next[getIndex(node.i, node.depth)] = new TrieNode(node.i, depth + 1);
		}
		int c = getIndex(i, node.depth);
		TrieNode x = node.next[c];
		if (x == null)
		{
			node.next[c] = new TrieNode(i, depth + 1);
			return depth;
		}
		return addNew(x, i);
	}
}
