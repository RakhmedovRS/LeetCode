package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 8/19/2023
 */
@LeetCode(
		id = 2828,
		name = "Check if a String Is an Acronym of Words",
		url = "https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words/",
		difficulty = Difficulty.EASY
)
public class CheckIfStringIsAcronymOfWords {
	public boolean isAcronym(List<String> words, String s) {
		StringBuilder sb = new StringBuilder();
		for (String w : words) {
			sb.append(w.charAt(0));
		}

		return sb.toString().equals(s);
	}
}
