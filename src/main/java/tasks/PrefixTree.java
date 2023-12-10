package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 07-Feb-20
 */
@LeetCode(id = 208, name = "Implement Trie (Prefix Tree)", url = "https://leetcode.com/problems/implement-trie-prefix-tree/")
public class PrefixTree {
	class Trie {

		class TrieNode {
			boolean[] chars;
			boolean isEnd;
			TrieNode[] children;

			public TrieNode() {
				chars = new boolean[26];
				children = new TrieNode[26];
			}
		}

		/**
		 * Initialize your data structure here.
		 */
		TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		/**
		 * Inserts a word into the trie.
		 */
		public void insert(String word) {
			TrieNode current = root;
			for (char ch : word.toCharArray()) {
				int pos = ch - 'a';
				current.chars[pos] = true;
				TrieNode next = current.children[pos];
				if (next == null) {
					current.children[pos] = new TrieNode();
					next = current.children[pos];
				}
				current = next;
			}
			current.isEnd = true;
		}

		/**
		 * Returns if the word is in the trie.
		 */
		public boolean search(String word) {
			TrieNode current = root;
			for (char ch : word.toCharArray()) {
				int pos = ch - 'a';
				if (current == null || !current.chars[pos]) {
					return false;
				}
				current = current.children[pos];
			}

			return current.isEnd;
		}

		/**
		 * Returns if there is any word in the trie that starts with the given prefix.
		 */
		public boolean startsWith(String prefix) {
			TrieNode current = root;
			for (char ch : prefix.toCharArray()) {
				int pos = ch - 'a';
				if (current == null || !current.chars[pos]) {
					return false;
				}
				current = current.children[pos];
			}

			return true;
		}
	}
}
