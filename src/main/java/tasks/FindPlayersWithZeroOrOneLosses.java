package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 6/21/2022
 */
@LeetCode(
		id = 2225,
		name = "Find Players With Zero or One Losses",
		url = "https://leetcode.com/problems/find-players-with-zero-or-one-losses/",
		difficulty = Difficulty.MEDIUM
)
public class FindPlayersWithZeroOrOneLosses {
	public List<List<Integer>> findWinners(int[][] matches) {
		int[] winners = new int[100_001];
		int[] losers = new int[100_001];

		for (int[] match : matches) {
			winners[match[0]]++;
			losers[match[1]]++;
		}

		List<Integer> neverLost = new ArrayList<>();
		List<Integer> lostOnce = new ArrayList<>();

		for (int i = 0; i < winners.length; i++) {
			if (winners[i] > 0 && losers[i] == 0) {
				neverLost.add(i);
			}

			if (winners[i] >= 0 && losers[i] == 1) {
				lostOnce.add(i);
			}
		}

		return Arrays.asList(neverLost, lostOnce);
	}
}
