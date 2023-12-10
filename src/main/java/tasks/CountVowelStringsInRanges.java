package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Ruslan Rakhmedov
 * @created 2/8/2023
 */
@LeetCode(
		id = 2559,
		name = "Count Vowel Strings in Ranges",
		url = "https://leetcode.com/problems/count-vowel-strings-in-ranges/",
		difficulty = Difficulty.MEDIUM
)
public class CountVowelStringsInRanges {
	public int[] vowelStrings(String[] words, int[][] queries) {
		TreeSet<Integer> set = new TreeSet<>();
		Set<Character> vowels = new HashSet<>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');

		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			if (vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1))) {
				set.add(i);
			}
		}

		int[] answer = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int left = queries[i][0];
			int right = queries[i][1];

			answer[i] = set.subSet(left, true, right, true).size();
		}

		return answer;
	}
}
