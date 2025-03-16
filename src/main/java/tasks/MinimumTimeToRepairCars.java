package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 3/21/2023
 */
@LeetCode(
		id = 2594,
		name = "Minimum Time to Repair Cars",
		url = "https://leetcode.com/problems/minimum-time-to-repair-cars/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumTimeToRepairCars {
	public long repairCars(int[] ranks, int cars) {
		long left = 0;
		long right = Long.MAX_VALUE / 4;
		long ans = 0;
		Arrays.sort(ranks);
		while (left <= right) {
			long mid = (left + right) / 2;
			if (canBeRepaired(ranks, cars, mid)) {
				right = mid - 1;
				ans = mid;
			} else {
				left = mid + 1;
			}
		}
		return ans;
	}

	private boolean canBeRepaired(int[] ranks, int cars, long maxTime) {
		for (int rank : ranks) {
			if (cars <= 0) {
				break;
			}

			if (rank > maxTime) {
				return false;
			}

			int carsRepaired = (int) Math.sqrt(maxTime / rank);
			cars -= carsRepaired;
			if (carsRepaired == 0) {
				break;
			}
		}

		return cars <= 0;
	}
}
