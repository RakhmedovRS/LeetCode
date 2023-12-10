package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 03-Jun-20
 */
@LeetCode(id = 1266, name = "Minimum Time Visiting All Points", url = "https://leetcode.com/problems/minimum-time-visiting-all-points/")
public class MinimumTimeVisitingAllPoints {
	public int minTimeToVisitAllPoints(int[][] points) {
		int steps = 0;
		for (int i = 1; i < points.length; i++) {
			steps += Math.max(Math.abs(points[i][0] - points[i - 1][0]), Math.abs(points[i][1] - points[i - 1][1]));
		}

		return steps;
	}
}
