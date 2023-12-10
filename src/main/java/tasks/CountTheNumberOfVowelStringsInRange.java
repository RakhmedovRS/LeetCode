package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 3/12/2023
 */
@LeetCode(
		id = 2586,
		name = "Count the Number of Vowel Strings in Range",
		url = "https://leetcode.com/problems/count-the-number-of-vowel-strings-in-range/",
		difficulty = Difficulty.EASY
)
public class CountTheNumberOfVowelStringsInRange {
	public int vowelStrings(String[] words, int left, int right) {
		Set<Character> vowels = new HashSet<>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');

		int count = 0;
		while (left <= right) {
			if (vowels.contains(words[left].charAt(0)) && vowels.contains(words[left].charAt(words[left].length() - 1))) {
				count++;
			}

			left++;
		}

		return count;
	}
}
