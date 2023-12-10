package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12-May-20
 */
@LeetCode(
		id = 374,
		name = "Guess Number Higher or Lower",
		url = "https://leetcode.com/problems/guess-number-higher-or-lower/",
		difficulty = Difficulty.EASY
)
public abstract class GuessNumberHigherOrLower {
	abstract int guess(int num);

	public int guessNumber(int n) {
		long left = 1;
		long right = n;
		long middle;
		int res;
		while (left <= right) {
			middle = (left + right) / 2;
			res = guess((int) middle);
			if (res == 0) {
				return (int) middle;
			}
			else if (res < 0) {
				right = middle - 1;
			}
			else {
				left = middle + 1;
			}
		}

		return (int) left;
	}
}
