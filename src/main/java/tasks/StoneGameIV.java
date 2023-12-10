package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/25/2020
 */
@LeetCode(
		id = 1510,
		name = "Stone Game IV",
		url = "https://leetcode.com/problems/stone-game-iv/",
		difficulty = Difficulty.HARD
)
public class StoneGameIV {
	public boolean winnerSquareGame(int n) {
		boolean[] memo = new boolean[n + 1];
		for (int i = 0; i < memo.length; i++) {
			for (int j = 1; j * j <= i; j++) {
				if (!memo[i - j * j]) {
					memo[i] = true;
					break;
				}
			}
		}

		return memo[n];
	}

	public static void main(String[] args) {
		System.out.println(new StoneGameIV().winnerSquareGame(1));
		System.out.println(new StoneGameIV().winnerSquareGame(2));
		System.out.println(new StoneGameIV().winnerSquareGame(17));
	}
}
