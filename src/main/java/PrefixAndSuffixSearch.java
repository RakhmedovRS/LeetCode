import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 11/4/2020
 */
@LeetCode(id = 745, name = "Prefix and Suffix Search", url = "https://leetcode.com/problems/prefix-and-suffix-search/")
public class PrefixAndSuffixSearch
{
	class Trie
	{
		Trie[] child = new Trie[27];
		int end = -1;
	}

	class WordFilter
	{

		Trie root;

		public WordFilter(String[] words)
		{
			root = new Trie();
			for (int i = 0; i < words.length; i++)
			{
				for (int j = 0; j <= words[i].length(); j++)
				{
					addToTrie(words[i].substring(words[i].length() - j) + "{" + words[i], i);
				}
			}
		}

		public int f(String prefix, String suffix)
		{
			return find(suffix + "{" + prefix);
		}

		private void addToTrie(String word, int pos)
		{
			Trie current = root;
			for (char ch : word.toCharArray())
			{
				if (current.child[ch - 'a'] == null)
				{
					current.child[ch - 'a'] = new Trie();
				}

				current = current.child[ch - 'a'];
			}

			current.end = pos;
		}

		private int find(String word)
		{
			Trie current = root;
			for (char ch : word.toCharArray())
			{
				if (current.child[ch - 'a'] == null)
				{
					return -1;
				}

				current = current.child[ch - 'a'];
			}

			int max = -1;
			Queue<Trie> queue = new LinkedList<>();
			queue.add(current);
			while (!queue.isEmpty())
			{
				current = queue.remove();
				max = Math.max(max, current.end);

				for (Trie next : current.child)
				{
					if (next != null)
					{
						queue.add(next);
					}
				}
			}

			return max;
		}
	}

	public static void main(String[] args)
	{
		//[9,4,5,0,8,1,2,5,3,1]
		WordFilter wordFilter = new PrefixAndSuffixSearch().new WordFilter(new String[]{"cabaabaaaa", "ccbcababac", "bacaabccba", "bcbbcbacaa", "abcaccbcaa", "accabaccaa", "cabcbbbcca", "ababccabcb", "caccbbcbab", "bccbacbcba"});
		System.out.println(wordFilter.f("bccbacbcba", "a"));
		System.out.println(wordFilter.f("ab", "abcaccbcaa"));
		System.out.println(wordFilter.f("a", "aa"));
		System.out.println(wordFilter.f("cabaaba", "abaaaa"));
		System.out.println(wordFilter.f("cacc", "accbbcbab"));
		System.out.println(wordFilter.f("ccbcab", "bac"));
		System.out.println(wordFilter.f("bac", "cba"));
		System.out.println(wordFilter.f("ac", "accabaccaa"));
		System.out.println(wordFilter.f("bcbb", "aa"));
		System.out.println(wordFilter.f("ccbca", "cbcababac"));

		wordFilter = new PrefixAndSuffixSearch().new WordFilter(new String[]{"apple"});
		System.out.println(wordFilter.f("a", "e"));
	}
}
