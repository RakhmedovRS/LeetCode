package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 4/30/2023
 */
@LeetCode(
		id = 2660,
		name = "Determine the Winner of a Bowling Game",
		url = "https://leetcode.com/problems/determine-the-winner-of-a-bowling-game/description/",
		difficulty = Difficulty.EASY
)
public class DetermineTheWinnerOfBowlingGame {
	public int isWinner(int[] player1, int[] player2) {
		int s1 = score(player1);
		int s2 = score(player2);
		if (s1 > s2) {
			return 1;
		}
		else if (s1 < s2) {
			return 2;
		}

		return 0;
	}

	private int score(int[] player) {
		int sum = 0;
		Integer lastIndexOf10 = null;
		for (int i = 0; i < player.length; i++) {
			if (lastIndexOf10 != null && i - lastIndexOf10 <= 2) {
				sum += 2 * player[i];
			}
			else {
				sum += player[i];
			}

			if (player[i] == 10) {
				lastIndexOf10 = i;
			}
		}

		return sum;
	}
}
