package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/25/2022
 */
@LeetCode(
		id = 2139,
		name = "Minimum Moves to Reach Target Score",
		url = "https://leetcode.com/problems/minimum-moves-to-reach-target-score/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumMovesToReachTargetScore {
	public int minMoves(int target, int maxDoubles) {
		int moves = 0;
		if (maxDoubles == 0) {
			return target - 1;
		}

		while (maxDoubles > 0 && target > 1) {
			if (target % 2 == 0) {
				maxDoubles--;
				target /= 2;
			}
			else {
				target--;
			}
			moves++;
		}

		if (target > 0) {
			moves += target - 1;
		}

		return moves;
	}
}
