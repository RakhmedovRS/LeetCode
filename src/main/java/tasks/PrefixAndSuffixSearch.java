package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/4/2020
 */
@LeetCode(
		id = 745,
		name = "Prefix and Suffix Search",
		url = "https://leetcode.com/problems/prefix-and-suffix-search/",
		difficulty = Difficulty.HARD
)
public class PrefixAndSuffixSearch {
	class Trie {
		private final Node root;

		class Node {
			Node[] children = new Node[28];
			int maxIndex = -1;
		}

		public Trie() {
			root = new Node();
		}

		public void addWord(char[] chars, int index) {
			Node current = root;
			for (char ch : chars) {
				if (current.children[ch - '_'] == null) {
					current.children[ch - '_'] = new Node();
				}

				current = current.children[ch - '_'];
				current.maxIndex = Math.max(current.maxIndex, index);
			}
		}

		public int find(char[] chars) {
			Node current = root;
			for (char ch : chars) {
				if (current.children[ch - '_'] == null) {
					return -1;
				}

				current = current.children[ch - '_'];
			}

			return current.maxIndex;
		}
	}

	class WordFilter {
		Trie trie;

		public WordFilter(String[] words) {
			trie = new Trie();
			String word;
			for (int index = 0; index < words.length; index++) {
				word = words[index];
				for (int i = 0; i < word.length(); i++) {
					StringBuilder sb = new StringBuilder();
					for (int j = word.length() - i - 1; j < word.length(); j++) {
						sb.append(word.charAt(j));
					}

					sb.append("_");
					sb.append(word);

					trie.addWord(sb.toString().toCharArray(), index);
				}
			}
		}

		public int f(String prefix, String suffix) {
			return trie.find((suffix + "_" + prefix).toCharArray());
		}
	}

	public static void main(String[] args) {
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
