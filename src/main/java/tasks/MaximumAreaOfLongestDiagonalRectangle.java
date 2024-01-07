package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 1/7/2024
 */
@LeetCode(
		id = 3000,
		name = "Maximum Area of Longest Diagonal Rectangle",
		url = "https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/",
		difficulty = Difficulty.EASY
)
public class MaximumAreaOfLongestDiagonalRectangle {
	public int areaOfMaxDiagonal(int[][] dimensions) {
		double maxDiagonal = 0d;
		double maxArea = 0;
		for (int[] d : dimensions) {
			double l = d[0];
			double w = d[1];
			double diagonal = Math.sqrt(l * l + w * w);
			if (diagonal >= maxDiagonal) {
				if (diagonal > maxDiagonal) {
					maxArea = l * w;
				} else {
					maxArea = Math.max(maxArea, l * w);
				}

				maxDiagonal = diagonal;
			}
		}

		return (int) maxArea;
	}
}
