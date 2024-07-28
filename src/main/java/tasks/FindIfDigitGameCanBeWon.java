package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-07-27
 */
@LeetCode(
		id = 3232,
		name = "Find if Digit Game Can Be Won",
		url = "https://leetcode.com/problems/find-if-digit-game-can-be-won/description/",
		difficulty = Difficulty.EASY
)
public class FindIfDigitGameCanBeWon {
	public boolean canAliceWin(int[] nums) {
		int oneD = 0;
		int twoD = 0;
		for (int n : nums) {
			if (n < 10) {
				oneD += n;
			} else {
				twoD += n;
			}
		}
		return oneD != twoD;
	}
}