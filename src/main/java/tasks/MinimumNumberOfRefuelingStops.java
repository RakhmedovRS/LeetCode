package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/11/2020
 */
@LeetCode(id = 871, name = "Minimum Number of Refueling Stops", url = "https://leetcode.com/problems/minimum-number-of-refueling-stops/")
public class MinimumNumberOfRefuelingStops {
	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		if (startFuel >= target) {
			return 0;
		}

		int gasStations = stations.length;

		long[] memo = new long[gasStations + 1];
		memo[0] = startFuel;
		for (int i = 0; i < gasStations; i++) {
			for (int j = i; j >= 0 && memo[j] >= stations[i][0]; j--) {
				memo[j + 1] = Math.max(memo[j + 1], memo[j] + stations[i][1]);
			}
		}

		for (int i = 0; i < memo.length; i++) {
			if (memo[i] >= target) {
				return i;
			}
		}

		return -1;
	}
}
