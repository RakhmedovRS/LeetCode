package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-04-04
 */
@LeetCode(
		id = 3064,
		name = "Guess the Number Using Bitwise Questions I",
		url = "https://leetcode.com/problems/guess-the-number-using-bitwise-questions-i/description/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class GuessTheNumberUsingBitwiseQuestionsI {
	private int commonSetBits(int num) {
		return 0;
	}

	public int findNumber() {
		int num = 0;
		for (int i = 0; i < 31; i++) {
			if (commonSetBits(1 << i) > 0) {
				num ^= (1 << i);
			}
		}
		return num;
	}
}