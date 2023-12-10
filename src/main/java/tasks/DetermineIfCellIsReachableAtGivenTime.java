package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 9/9/2023
 */
@LeetCode(
		id = 2849,
		name = "Determine if a Cell Is Reachable at a Given Time",
		url = "https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time/",
		difficulty = Difficulty.MEDIUM
)
public class DetermineIfCellIsReachableAtGivenTime {
	public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
		int dist = eucDistance(new int[]{sx, sy}, new int[]{fx, fy});
		if (dist == 0) {
			return t == 0 || t > 1;
		}

		int xDiff = Math.abs(sx - fx);
		int yDiff = Math.abs(sy - fy);

		if (xDiff >= yDiff) {
			xDiff -= yDiff;
			return xDiff + yDiff <= t;
		}
		else {
			yDiff -= xDiff;
			return xDiff + yDiff <= t;
		}
	}

	private int eucDistance(int[] a, int[] b) {
		double xX = a[0] - b[0];
		double yY = a[1] - b[1];
		return (int) Math.sqrt(xX * xX + yY * yY);
	}
}
