package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 31-Jul-20
 */
@LeetCode(id = 472, name = "Concatenated Words", url = "https://leetcode.com/problems/concatenated-words/")
public class ConcatenatedWords
{
	class Node
	{
		Node[] child = new Node[26];
		boolean end = false;
	}

	public Node buildTrie(String[] words)
	{
		Node root = new Node();
		for (String word : words)
		{
			Node temp = root;
			for (char ch : word.toCharArray())
			{
				if (temp.child[ch - 'a'] == null)
				{
					temp.child[ch - 'a'] = new Node();
				}

				temp = temp.child[ch - 'a'];
			}

			temp.end = true;
		}

		return root;
	}

	public List<String> findAllConcatenatedWordsInADict(String[] words)
	{
		Node root = buildTrie(words);
		List<String> answer = new ArrayList<>();
		for (String word : words)
		{
			if (canBeSplited(root, word, 0, 0))
			{
				answer.add(word);
			}
		}

		return answer;
	}

	private boolean canBeSplited(Node root, String word, int pos, int words)
	{
		if (pos == word.length())
		{
			return words > 1;
		}

		Node current = root;
		for (int i = pos; i < word.length(); i++)
		{
			current = current.child[word.charAt(i) - 'a'];
			if (current == null)
			{
				return false;
			}

			if (current.end && canBeSplited(root, word, i + 1, words+1))
			{
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args)
	{
		System.out.println(new ConcatenatedWords().findAllConcatenatedWordsInADict(
			new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"})
		);
	}
}
