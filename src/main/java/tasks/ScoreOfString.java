package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-04-13
 */
@LeetCode(
		id = 3110,
		name = "Score of a String",
		url = "https://leetcode.com/problems/score-of-a-string/description/",
		difficulty = Difficulty.EASY
)
public class ScoreOfString {
	public int scoreOfString(String s) {
		int score = 0;
		for (int i = 1; i < s.length(); i++) {
			score += Math.abs(s.charAt(i - 1) - s.charAt(i));
		}
		return score;
	}
}