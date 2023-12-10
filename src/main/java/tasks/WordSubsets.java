package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 10-May-20
 */
@LeetCode(
		id = 916,
		name = "Word tasks.Subsets",
		url = "https://leetcode.com/problems/word-subsets/",
		difficulty = Difficulty.MEDIUM
)
public class WordSubsets {
	public List<String> wordSubsets(String[] words1, String[] words2) {
		List<String> answer = new ArrayList<>();
		int[] memo = new int[26];
		for (String word : words2) {
			int[] temp = createCharFrequencyTable(word);
			for (int i = 0; i < 26; i++) {
				memo[i] = Math.max(memo[i], temp[i]);
			}
		}

		outer:
		for (String word : words1) {
			int[] current = createCharFrequencyTable(word);

			for (int i = 0; i < 26; i++) {
				if (memo[i] > current[i]) {
					continue outer;
				}
			}

			answer.add(word);
		}

		return answer;
	}

	public int[] createCharFrequencyTable(String word) {
		int[] pattern = new int[26];
		for (char ch : word.toCharArray()) {
			if (Character.isAlphabetic(ch)) {
				pattern[Character.toLowerCase(ch) - 'a']++;
			}
		}

		return pattern;
	}
}
