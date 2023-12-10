package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 10/28/2020
 */
@LeetCode(
		id = 822,
		name = "Card Flipping Game",
		url = "https://leetcode.com/problems/card-flipping-game/",
		difficulty = Difficulty.MEDIUM
)
public class CardFlippingGame {
	public int flipgame(int[] fronts, int[] backs) {
		Set<Integer> badCovers = new HashSet<>();
		for (int i = 0; i < fronts.length; i++) {
			if (fronts[i] == backs[i]) {
				badCovers.add(fronts[i]);
			}
		}

		if (badCovers.size() == fronts.length) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < fronts.length; i++) {
			if (fronts[i] != backs[i]) {
				if (!badCovers.contains(fronts[i])) {
					min = Math.min(min, fronts[i]);
				}

				if (!badCovers.contains(backs[i])) {
					min = Math.min(min, backs[i]);
				}
			}
		}

		return min == Integer.MAX_VALUE ? 0 : min;
	}
}
