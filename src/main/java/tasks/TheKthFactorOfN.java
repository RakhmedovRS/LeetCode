package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 27-Jun-20
 */
@LeetCode(
		id = 1492,
		name = "The kth Factor of n",
		url = "https://leetcode.com/problems/the-kth-factor-of-n/",
		difficulty = Difficulty.MEDIUM
)
public class TheKthFactorOfN {
	public int kthFactor(int n, int k) {
		int i = 1;
		for (; i <= n; i++) {
			if (n % i == 0) {
				k--;

				if (k == 0) {
					break;
				}
			}
		}

		return k == 0 ? i : -1;
	}
}
