package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 9/5/2022
 */
@LeetCode(
		id = 2391,
		name = "Minimum Amount of Time to Collect Garbage",
		url = "https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumAmountOfTimeToCollectGarbage {
	public int garbageCollection(String[] garbage, int[] travel) {
		boolean[] seenPaper = new boolean[garbage.length];
		boolean[] seenGlass = new boolean[garbage.length];
		boolean[] seenMetal = new boolean[garbage.length];

		boolean paper;
		boolean glass;
		boolean metal;
		for (int i = garbage.length - 1; i >= 0; i--) {
			paper = garbage[i].contains("P");
			glass = garbage[i].contains("G");
			metal = garbage[i].contains("M");

			seenPaper[i] = paper || (i != garbage.length - 1 && seenPaper[i + 1]);
			seenGlass[i] = glass || (i != garbage.length - 1 && seenGlass[i + 1]);
			seenMetal[i] = metal || (i != garbage.length - 1 && seenMetal[i + 1]);
		}

		int result = 0;
		int timeToCollectPaper = 0;
		for (int i = 0; i < garbage.length; i++) {
			if (!seenPaper[i]) {
				break;
			}

			if (i > 0) {
				timeToCollectPaper += travel[i - 1];
			}

			for (int j = 0; j < garbage[i].length(); j++) {
				if (garbage[i].charAt(j) == 'P') {
					timeToCollectPaper++;
				}
			}
		}

		int timeToCollectGlass = 0;
		for (int i = 0; i < garbage.length; i++) {
			if (!seenGlass[i]) {
				break;
			}

			if (i > 0) {
				timeToCollectGlass += travel[i - 1];
			}

			for (int j = 0; j < garbage[i].length(); j++) {
				if (garbage[i].charAt(j) == 'G') {
					timeToCollectGlass++;
				}
			}
		}

		int timeToCollectMetal = 0;
		for (int i = 0; i < garbage.length; i++) {
			if (!seenMetal[i]) {
				break;
			}

			if (i > 0) {
				timeToCollectMetal += travel[i - 1];
			}

			for (int j = 0; j < garbage[i].length(); j++) {
				if (garbage[i].charAt(j) == 'M') {
					timeToCollectMetal++;
				}
			}
		}

		return timeToCollectPaper + timeToCollectGlass + timeToCollectMetal;
	}
}
