package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 28-Jul-20
 */
@LeetCode(
	id = 812,
	name = "Largest tasks.Triangle Area",
	url = "https://leetcode.com/problems/largest-triangle-area/",
	difficulty = Difficulty.EASY
)
public class LargestTriangleArea
{
	public double largestTriangleArea(int[][] points) {
		int xA;
		int yA;
		int xB;
		int yB;
		int xC;
		int yC;
		double max = 0;
		for (int a = 0; a < points.length; a++) {
			for (int b = a + 1; b < points.length; b++) {
				for (int c = b + 1; c < points.length; c++) {
					xA = points[a][0];
					yA = points[a][1];
					xB = points[b][0];
					yB = points[b][1];
					xC = points[c][0];
					yC = points[c][1];
					max = Math.max(max, .5D * Math.abs(xA * yB + xB * yC + xC * yA - xA * yC - xC * yB - xB * yA));
				}
			}
		}

		return max;
	}
}
