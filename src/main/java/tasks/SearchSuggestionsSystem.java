package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 2/10/2021
 */
@LeetCode(
		id = 1268,
		name = "Search Suggestions System",
		url = "https://leetcode.com/problems/search-suggestions-system/",
		difficulty = Difficulty.MEDIUM
)
public class SearchSuggestionsSystem
{
	class Trie
	{
		class Node
		{
			Node[] children = new Node[26];
			List<String> endWords = new ArrayList<>(4);
		}

		Node root;

		public Trie()
		{
			root = new Node();
		}

		public void addWord(String word)
		{
			Node current = root;
			for (char ch : word.toCharArray())
			{
				if (current.children[ch - 'a'] == null)
				{
					current.children[ch - 'a'] = new Node();
				}

				current = current.children[ch - 'a'];
			}

			if (current.endWords.size() < 3)
			{
				current.endWords.add(word);
			}
		}
	}

	public List<List<String>> suggestedProducts(String[] products, String searchWord)
	{
		List<List<String>> answer = new ArrayList<>();
		Trie trie = new Trie();
		for (String product : products)
		{
			trie.addWord(product);
		}

		Trie.Node current = trie.root;
		for (char ch : searchWord.toCharArray())
		{
			List<String> list = new ArrayList<>();
			if (current != null)
			{
				current = current.children[ch - 'a'];
				dfs(current, list);
			}

			answer.add(list);
		}

		return answer;
	}

	private void dfs(Trie.Node current, List<String> list)
	{
		if (current == null || list.size() == 3)
		{
			return;
		}

		for (int i = 0; i < current.endWords.size() && list.size() < 3; i++)
		{
			list.add(current.endWords.get(i));
		}

		for (Trie.Node next : current.children)
		{
			if (next != null)
			{
				dfs(next, list);
			}
		}
	}
}
