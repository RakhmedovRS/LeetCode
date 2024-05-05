package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-05-04
 */
@LeetCode(
		id = 3136,
		name = "Valid Word",
		url = "https://leetcode.com/problems/valid-word/description/",
		difficulty = Difficulty.EASY
)
public class ValidWord {
	public boolean isValid(String word) {
		if (word.length() < 3) {
			return false;
		}
		boolean hasVowel = false;
		boolean hasConsonant = false;

		Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		Set<Character> consonants = new HashSet<>(Arrays.asList('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'));
		for (char ch : word.toCharArray()) {

			if (vowels.contains(Character.toLowerCase(ch))) {
				hasVowel = true;
			}

			if (consonants.contains(Character.toLowerCase(ch))) {
				hasConsonant = true;
			}

			if (!Character.isLetterOrDigit(ch)) {
				return false;
			}
		}

		return hasVowel && hasConsonant;
	}
}