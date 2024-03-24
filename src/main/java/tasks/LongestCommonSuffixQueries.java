package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-03-23
 */
@LeetCode(
		id = 3093,
		name = "Longest Common Suffix Queries",
		url = "https://leetcode.com/problems/longest-common-suffix-queries/description/",
		difficulty = Difficulty.HARD
)
public class LongestCommonSuffixQueries {
	class Trie {

		TrieNode root;
		String[] wordsContainer;

		public Trie(String[] wordsContainer) {
			this.root = new TrieNode();
			this.wordsContainer = wordsContainer;

		}

		class TrieNode {
			TrieNode[] children = new TrieNode[26];
			List<Integer> ids = new ArrayList<>();
			boolean sorted = false;
		}

		public void addToTrie(char[] chars, int index) {
			TrieNode current = root;
			for (int i = chars.length - 1; i >= 0; i--) {
				char ch = chars[i];
				if (current.children[ch - 'a'] == null) {
					current.children[ch - 'a'] = new TrieNode();
				}

				current.ids.add(index);

				current = current.children[ch - 'a'];
			}
			current.ids.add(index);
		}


		public int find(char[] chars) {
			TrieNode current = root;
			for (int i = chars.length - 1; i >= 0; i--) {
				char ch = chars[i];
				if (current.children[ch - 'a'] == null) {
					break;
				}

				current = current.children[ch - 'a'];
			}

			if (!current.sorted) {
				current.ids.sort((i, j) -> {
					if (wordsContainer[i].length() == wordsContainer[j].length()) {
						return i - j;
					}

					return wordsContainer[i].length() - wordsContainer[j].length();
				});
			}

			return current.ids.get(0);
		}
	}


	public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
		Trie trie = new Trie(wordsContainer);
		for (int i = 0; i < wordsContainer.length; i++) {
			trie.addToTrie(wordsContainer[i].toCharArray(), i);
		}

		int[] ans = new int[wordsQuery.length];
		for (int i = 0; i < wordsQuery.length; i++) {
			ans[i] = trie.find(wordsQuery[i].toCharArray());
		}

		return ans;
	}
}