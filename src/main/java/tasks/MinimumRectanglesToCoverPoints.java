package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-04-13
 */
@LeetCode(
		id = 3111,
		name = "Minimum Rectangles to Cover Points",
		url = "https://leetcode.com/problems/minimum-rectangles-to-cover-points/description/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumRectanglesToCoverPoints {
	public int minRectanglesToCoverPoints(int[][] points, int w) {
		int rectangles = 0;
		Arrays.sort(points, (a, b) -> a[0] - b[0]);
		LinkedList<int[]> list = new LinkedList<>();
		for (int[] point : points) {
			if (list.isEmpty()) {
				rectangles++;
				list.addLast(point);
				continue;
			}

			if (list.getFirst()[0] + w < point[0]) {
				rectangles++;
				list.clear();
				list.addLast(point);
			}
		}

		return rectangles;
	}
}