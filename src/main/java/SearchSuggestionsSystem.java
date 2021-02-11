import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
		List<String> words = new ArrayList<>();
		Trie[] children = new Trie[26];

		public void add(String word)
		{
			if (words.size() < 3)
			{
				words.add(word);
			}
		}
	}

	public List<List<String>> suggestedProducts(String[] products, String searchWord)
	{
		Arrays.sort(products);
		List<List<String>> answer = new ArrayList<>();
		Trie root = new Trie();
		for (String product : products)
		{
			addToTrie(root, product);
		}

		Trie current = root;
		for (int i = 0; i < searchWord.length(); i++)
		{
			current = current.children[searchWord.charAt(i) - 'a'];
			if (current == null)
			{
				for (int j = i; j < searchWord.length(); j++)
				{
					answer.add(Collections.emptyList());
				}
				break;
			}

			answer.add(current.words);
		}

		return answer;
	}

	private void addToTrie(Trie root, String word)
	{
		Trie current = root;
		int index;
		for (int i = 0; i < word.length(); i++)
		{
			index = word.charAt(i) - 'a';
			if (current.children[index] == null)
			{
				current.children[index] = new Trie();
			}

			current = current.children[index];
			current.add(word);
		}
	}
}
