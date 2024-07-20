package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-07-20
 */
@LeetCode(
		id = 3222,
		name = "Find the Winning Player in Coin Game",
		url = "https://leetcode.com/problems/find-the-winning-player-in-coin-game/description/",
		difficulty = Difficulty.EASY
)
public class FindTheWinningPlayerInCoinGame {
	public String losingPlayer(int x, int y) {
		boolean alice = true;
		while (x > 0 && y > 0) {
			if (x > 0 && y >= 4) {
				x -= 1;
				y -= 4;
				alice = !alice;
			} else {
				return alice ? "Bob" : "Alice";
			}
		}
		return alice ? "Bob" : "Alice";
	}
}