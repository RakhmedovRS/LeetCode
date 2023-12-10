package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 3/17/2021
 */
@LeetCode(
		id = 478,
		name = "Generate Random Point in a Circle",
		url = "https://leetcode.com/problems/generate-random-point-in-a-circle/",
		difficulty = Difficulty.MEDIUM
)
public class GenerateRandomPointInCircle {
	class Solution {
		double radius;
		double x_center;
		double y_center;

		public Solution(double radius, double x_center, double y_center) {
			this.radius = radius;
			this.x_center = x_center;
			this.y_center = y_center;
		}

		public double[] randPoint() {
			double x0 = x_center - radius;
			double y0 = y_center - radius;

			while (true) {
				double xg = x0 + Math.random() * radius * 2;
				double yg = y0 + Math.random() * radius * 2;
				if (Math.sqrt(Math.pow((xg - x_center), 2) + Math.pow((yg - y_center), 2)) <= radius) {
					return new double[]{xg, yg};
				}
			}
		}
	}
}
