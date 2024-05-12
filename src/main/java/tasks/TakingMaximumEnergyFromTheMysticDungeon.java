package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-05-11
 */
@LeetCode(
		id = 3147,
		name = "Taking Maximum Energy From the Mystic Dungeon",
		url = "https://leetcode.com/problems/taking-maximum-energy-from-the-mystic-dungeon/description/",
		difficulty = Difficulty.MEDIUM
)
public class TakingMaximumEnergyFromTheMysticDungeon {
	public int maximumEnergy(int[] energy, int k) {
		Integer[] memo = new Integer[energy.length];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < energy.length; i++) {
			if (memo[i] == null) {
				memo[i] = energy[i];
			} else {
				memo[i] = Math.max(memo[i] + energy[i], energy[i]);
			}

			if (i + k < energy.length) {
				memo[i + k] = (memo[i + k] == null) ? memo[i] : Math.max(memo[i], memo[i + k]);
			} else {
				max = Math.max(max, memo[i]);
			}
		}

		return max;
	}
}