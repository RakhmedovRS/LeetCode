package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 13-Feb-20
 */
@LeetCode(
		id = 509,
		name = "Fibonacci Number",
		url = "https://leetcode.com/problems/fibonacci-number/",
		difficulty = Difficulty.EASY
)
public class FibonacciNumber {
	public int fib(int n) {
		int[] memo = new int[Math.max(3, n + 1)];
		memo[0] = 0;
		memo[1] = 1;

		for (int i = 2; i < memo.length; i++) {
			memo[i] = memo[i - 2] + memo[i - 1];
		}

		return memo[n];
	}
}
