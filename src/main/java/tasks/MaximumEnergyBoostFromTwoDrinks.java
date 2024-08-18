package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-08-17
 */
@LeetCode(
		id = 3259,
		name = "Maximum Energy Boost From Two Drinks",
		url = "https://leetcode.com/problems/maximum-energy-boost-from-two-drinks/description/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumEnergyBoostFromTwoDrinks {
	public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
		long max = 0;
		long sum = 0;
		for (int a : energyDrinkA) {
			sum += a;
		}
		max = Math.max(max, sum);

		sum = 0;
		for (int b : energyDrinkB) {
			sum += b;
		}
		max = Math.max(max, sum);

		long[][] memo = new long[energyDrinkA.length][2];
		memo[0][0] = energyDrinkA[0];
		memo[0][1] = energyDrinkB[0];

		for (int i = 1; i < energyDrinkA.length; i++) {
			memo[i][0] = energyDrinkA[i] + memo[i - 1][0];
			memo[i][1] = energyDrinkB[i] + memo[i - 1][1];
			if (i - 2 >= 0) {
				memo[i][0] = Math.max(memo[i][0], memo[i - 2][1] + energyDrinkA[i]);
				memo[i][1] = Math.max(memo[i][1], memo[i - 2][0] + energyDrinkB[i]);
			}
			max = Math.max(max, memo[i][0]);
			max = Math.max(max, memo[i][1]);
		}

		return max;
	}
}