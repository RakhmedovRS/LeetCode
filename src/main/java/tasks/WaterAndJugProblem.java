package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 20-Aug-20
 */
@LeetCode(id = 365, name = "Water and Jug Problem", url = "https://leetcode.com/problems/water-and-jug-problem/")
public class WaterAndJugProblem {
	public boolean canMeasureWater(int x, int y, int z) {
		if (x + y < z) {
			return false;
		}

		int gcd = gcd(x, y);
		if (gcd == 0 && z != 0) {
			return false;
		}

		return gcd == 0 || z % gcd == 0;
	}

	private int gcd(int x, int y) {
		if (y == 0) {
			return x;
		}
		return gcd(y, x % y);
	}
}
