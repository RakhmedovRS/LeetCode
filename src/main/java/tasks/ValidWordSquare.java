package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.List;

/**
 * @author RakhmedovRS
 * @created 12/22/2020
 */
@LeetCode(
		id = 422,
		name = "Valid Word Square",
		url = "https://leetcode.com/problems/valid-word-square/",
		difficulty = Difficulty.EASY,
		premium = true
)
public class ValidWordSquare {
	public boolean validWordSquare(List<String> words) {
		for (int i = 0; i < words.size(); i++) {
			StringBuilder sb = new StringBuilder();
			for (String word : words) {
				if (i < word.length()) {
					sb.append(word.charAt(i));
				}
			}

			if (!words.get(i).equals(sb.toString())) {
				return false;
			}
		}

		return true;
	}
}
