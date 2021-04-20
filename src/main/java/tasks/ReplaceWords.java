package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 10-Jul-20
 */
@LeetCode(id = 648, name = "Replace Words", url = "https://leetcode.com/problems/replace-words/")
public class ReplaceWords
{
	class TrieNode
	{
		TrieNode[] child;
		boolean end;

		public TrieNode()
		{
			this.child = new TrieNode[26];
		}
	}

	public String replaceWords(List<String> dict, String sentence)
	{
		TrieNode root = new TrieNode();
		for (String word : dict)
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

		List<String> words = new ArrayList<>();
		for (String word : sentence.split(" "))
		{
			TrieNode current = root;
			StringBuilder sb = new StringBuilder();
			boolean found = false;
			for (char ch : word.toCharArray())
			{
				if (current == null)
				{
					break;
				}
				sb.append(ch);
				current = current.child[ch - 'a'];
				if (current != null && current.end)
				{
					found = true;
					break;
				}
			}

			if (found)
			{
				words.add(sb.toString());
			}
			else
			{
				words.add(word);
			}
		}

		return String.join(" ", words);
	}
}
