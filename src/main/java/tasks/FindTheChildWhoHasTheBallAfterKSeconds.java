package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-06-09
 */
@LeetCode(
		id = 3178,
		name = "Find the Child Who Has the Ball After K Seconds",
		url = "https://leetcode.com/problems/find-the-child-who-has-the-ball-after-k-seconds/description/",
		difficulty = Difficulty.EASY
)
public class FindTheChildWhoHasTheBallAfterKSeconds {
	public int numberOfChild(int n, int k) {
		int i = 0;
		boolean leftToRight = true;
		while (k-- > 0) {
			if (leftToRight) {
				i++;
				if (i == n - 1) {
					leftToRight = false;
				}
			} else {
				i--;
				if (i == 0) {
					leftToRight = true;
				}
			}
		}
		return i;
	}
}