package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-07-06
 */
@LeetCode(
		id = 3207,
		name = "Maximum Points After Enemy Battles",
		url = "https://leetcode.com/problems/maximum-points-after-enemy-battles/description/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumPointsAfterEnemyBattles {
	public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
		Arrays.sort(enemyEnergies);
		int left = 0;
		int right = enemyEnergies.length - 1;
		long points = 0;
		long obtainedPoints = 0;
		while (left <= right) {
			if (enemyEnergies[left] <= currentEnergy) {
				long ops = (currentEnergy / enemyEnergies[left]);
				currentEnergy -= ops * enemyEnergies[left];
				points += ops;
				obtainedPoints += ops;
			} else if (points > 0) {
				currentEnergy += enemyEnergies[right--];
				points--;
			} else {
				break;
			}
		}
		return obtainedPoints;
	}
}