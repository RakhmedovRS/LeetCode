package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 9/25/2022
 */
@LeetCode(
		id = 2416,
		name = "Sum of Prefix Scores of Strings",
		url = "https://leetcode.com/problems/sum-of-prefix-scores-of-strings/",
		difficulty = Difficulty.HARD
)
public class SumOfPrefixScoresOfStrings {
	class Trie {
		private final Trie.Node root;

		class Node {
			Trie.Node[] children = new Trie.Node[26];
			int count = 0;
		}

		public Trie() {
			root = new Trie.Node();
		}

		public void addWord(char[] chars) {
			Trie.Node current = root;
			for (char ch : chars) {
				if (current.children[ch - 'a'] == null) {
					current.children[ch - 'a'] = new Trie.Node();
				}

				current = current.children[ch - 'a'];
				current.count++;
			}
		}

		public int find(char[] chars) {
			Trie.Node current = root;
			int count = 0;
			for (char ch : chars) {
				count += current.count;

				if (current.children[ch - 'a'] == null) {
					break;
				}

				current = current.children[ch - 'a'];
			}

			if (current != null) {
				count += current.count;
			}

			return count;
		}
	}

	public int[] sumPrefixScores(String[] words) {
		Trie trie = new Trie();

		for (String word : words) {
			char[] chars = word.toCharArray();
			trie.addWord(chars);
		}

		int[] answer = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			answer[i] = trie.find(words[i].toCharArray());
		}

		return answer;
	}
}
