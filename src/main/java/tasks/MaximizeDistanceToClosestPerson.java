package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/29/2020
 */
@LeetCode(
		id = 849,
		name = "Maximize Distance to Closest Person",
		url = "https://leetcode.com/problems/maximize-distance-to-closest-person/",
		difficulty = Difficulty.MEDIUM
)
public class MaximizeDistanceToClosestPerson {
	public int maxDistToClosest(int[] seats) {
		int prev = -1;
		int max = 0;
		int middle;
		for (int i = 0; i < seats.length; i++) {
			if (seats[i] == 0) {
				while (i < seats.length && seats[i] == 0) {
					i++;
				}

				if (prev != -1) {
					if (i < seats.length && seats[i] == 1) {
						middle = (prev + i) / 2;
						max = Math.max(max, Math.min(middle - prev, i - middle));
					}
					else {
						max = Math.max(max, i - prev - 1);
					}
				}
				else {
					max = Math.max(max, i - prev - 1);
				}
			}

			prev = i;
		}

		return max;
	}
}
