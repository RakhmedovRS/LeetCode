package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 11/25/2023
 */
@LeetCode(
		id = 2942,
		name = "Find Words Containing Character",
		url = "https://leetcode.com/problems/find-words-containing-character/",
		difficulty = Difficulty.EASY
)
public class FindWordsContainingCharacter {
	public List<Integer> findWordsContaining(String[] words, char x) {
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			if (words[i].contains("" + x)) {
				ans.add(i);
			}
		}

		return ans;
	}
}
