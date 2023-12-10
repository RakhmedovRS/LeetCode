package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 09-Apr-20
 */
@LeetCode(
		id = 50,
		name = "Pow(x, n)",
		url = "https://leetcode.com/problems/powx-n/",
		difficulty = Difficulty.MEDIUM
)
public class Pow {
	public double myPow(double x, int n) {
		if (n < 0) {
			return 1 / x * myPow(1 / x, -(n + 1));
		}
		if (n == 0) {
			return 1;
		}
		if (n == 2) {
			return x * x;
		}
		if (n % 2 == 0) {
			return myPow(myPow(x, n / 2), 2);
		}
		else {
			return x * myPow(myPow(x, n / 2), 2);
		}
	}

	public static void main(String[] args) {
		System.out.println(new Pow().myPow(2, -10));
	}
}
