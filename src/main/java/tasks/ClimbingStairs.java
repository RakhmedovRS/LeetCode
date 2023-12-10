package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 13-Feb-20
 */
@LeetCode(
		id = 70,
		name = "Climbing Stairs",
		url = "https://leetcode.com/problems/climbing-stairs/",
		difficulty = Difficulty.EASY
)
public class ClimbingStairs {
	public int climbStairs(int n) {
		if (n <= 2) {
			return n;
		}

		int[] memo = new int[n];
		memo[0] = 1;
		memo[1] = 2;

		for (int i = 2; i < n; i++) {
			memo[i] = memo[i - 2] + memo[i - 1];
		}

		return memo[n - 1];
	}
}
