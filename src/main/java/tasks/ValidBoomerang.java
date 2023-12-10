package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 9/24/2020
 */
@LeetCode(
		id = 1037,
		name = "Valid Boomerang",
		url = "https://leetcode.com/problems/valid-boomerang/",
		difficulty = Difficulty.EASY
)
public class ValidBoomerang {
	public boolean isBoomerang(int[][] points) {
		int[] a = points[0];
		int[] b = points[1];
		int[] c = points[2];
		return (a[1] - b[1]) * (c[0] - b[0]) != (c[1] - b[1]) * (a[0] - b[0]);
	}
}
