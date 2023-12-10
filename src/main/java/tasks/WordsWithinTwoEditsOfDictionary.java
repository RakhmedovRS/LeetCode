package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 10/30/2022
 */
@LeetCode(
		id = 2452,
		name = "Words Within Two Edits of Dictionary",
		url = "https://leetcode.com/problems/words-within-two-edits-of-dictionary/",
		difficulty = Difficulty.MEDIUM
)
public class WordsWithinTwoEditsOfDictionary {
	class Node {
		Node[] children = new Node[26];
		int end;
	}

	class Trie {
		private final Node root;

		public Trie() {
			root = new Node();
		}

		public void insert(String word) {
			Node current = root;
			int pos;
			for (char ch : word.toCharArray()) {
				pos = ch - 'a';
				if (current.children[pos] == null) {
					current.children[pos] = new Node();
				}

				current = current.children[pos];
			}

			current.end++;
		}

		public boolean find(Node node, char[] word, int pos, int mismatches) {
			if (mismatches > 2 || node == null) {
				return false;
			}

			if (pos == word.length) {
				return true;
			}

			for (int i = 0; i < node.children.length; i++) {
				if (node.children[i] != null) {
					if (i == word[pos] - 'a') {
						if (find(node.children[i], word, pos + 1, mismatches)) {
							return true;
						}
					}
					else {
						if (find(node.children[i], word, pos + 1, mismatches + 1)) {
							return true;
						}
					}
				}
			}

			return false;
		}
	}

	public List<String> twoEditWords(String[] queries, String[] dictionary) {
		Trie root = new Trie();
		for (String word : dictionary) {
			root.insert(word);
		}

		List<String> answer = new ArrayList<>();
		for (String query : queries) {
			if (root.find(root.root, query.toCharArray(), 0, 0)) {
				answer.add(query);
			}
		}

		return answer;
	}
}
