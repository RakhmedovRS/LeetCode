package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 22-Feb-20
 */
@LeetCode(
		id = 140,
		name = "Word Break",
		url = "https://leetcode.com/problems/word-break-ii/",
		difficulty = Difficulty.HARD
)
public class WordBreakII
{
	class TrieNode
	{
		TrieNode[] children = new TrieNode[26];
		boolean isEnd;
	}

	private TrieNode fillInTheTrie(List<String> wordDict)
	{
		TrieNode root = new TrieNode();
		for (String word : wordDict)
		{
			TrieNode node = root;
			for (char ch : word.toCharArray())
			{
				if (node.children[ch - 'a'] == null)
				{
					node.children[ch - 'a'] = new TrieNode();
				}
				node = node.children[ch - 'a'];
			}
			node.isEnd = true;
		}

		return root;
	}

	public boolean wordBreak(String s, List<String> wordDict)
	{
		TrieNode root = fillInTheTrie(wordDict);
		return dfs(root, s, 0, new Boolean[s.length() + 1]);
	}

	private boolean dfs(TrieNode root, String word, int pos, Boolean[] memo)
	{
		if (pos == word.length())
		{
			return true;
		}

		if (memo[pos] != null)
		{
			return memo[pos];
		}

		TrieNode node = root;
		for (int i = pos; i < word.length(); i++)
		{
			node = node.children[word.charAt(i) - 'a'];
			if (node == null)
			{
				break;
			}

			if (node.isEnd && dfs(root, word, i + 1, memo))
			{
				return memo[pos] = true;
			}
		}

		return memo[pos] = false;
	}

	public static void main(String[] args)
	{
		System.out.println(new WordBreakII().wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
	}
}
