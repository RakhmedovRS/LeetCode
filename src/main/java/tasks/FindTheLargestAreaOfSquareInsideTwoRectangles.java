package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-02-24
 */
@LeetCode(
		id = 3047,
		name = "Find the Largest Area of Square Inside Two Rectangles",
		url = "https://leetcode.com/problems/find-the-largest-area-of-square-inside-two-rectangles/description/",
		difficulty = Difficulty.MEDIUM
)
public class FindTheLargestAreaOfSquareInsideTwoRectangles {
	public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
		long ans = 0;
		for (int i = 0; i < bottomLeft.length; i++) {
			int bottomIx = bottomLeft[i][0];
			int bottomIy = bottomLeft[i][1];
			int topIx = topRight[i][0];
			int topIy = topRight[i][1];

			for (int j = i + 1; j < bottomLeft.length; j++) {
				int bottomJx = bottomLeft[j][0];
				int bottomJy = bottomLeft[j][1];
				int topJx = topRight[j][0];
				int topJy = topRight[j][1];

				int maxBottomX = Math.max(bottomIx, bottomJx);
				int maxBottomY = Math.max(bottomIy, bottomJy);
				int minTopX = Math.min(topIx, topJx);
				int minTopY = Math.min(topIy, topJy);
				int min = Math.min(Math.max(0, minTopX - maxBottomX), Math.max(0, minTopY - maxBottomY));
				ans = Math.max(ans, (long) min * min);
			}
		}

		return ans;
	}
}