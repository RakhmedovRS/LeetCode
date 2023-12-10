package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 6/23/2022
 */
@LeetCode(
		id = 2140,
		name = "Solving Questions With Brainpower",
		url = "https://leetcode.com/problems/solving-questions-with-brainpower/",
		difficulty = Difficulty.MEDIUM
)
public class SolvingQuestionsWithBrainpower {
	public long mostPoints(int[][] questions) {
		long max = 0;
		long[] memo = new long[questions.length];
		for (int i = 0; i < questions.length; i++) {
			memo[i] = Math.max(i > 0 ? memo[i - 1] : 0, memo[i]);
			int points = questions[i][0];
			int skip = questions[i][1] + 1;

			max = Math.max(max, memo[i] + points);
			if (i + skip < memo.length) {
				memo[i + skip] = Math.max(memo[i + skip], memo[i] + points);
			}
		}

		return max;
	}
}
