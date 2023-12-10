package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 16-Aug-20
 */
@LeetCode(id = 1550, name = "Three Consecutive Odds", url = "https://leetcode.com/problems/three-consecutive-odds/")
public class ThreeConsecutiveOdds {
	public boolean threeConsecutiveOdds(int[] arr) {
		int count = 0;
		for (int num : arr) {
			if (num % 2 != 0) {
				count++;
			}
			else {
				count = 0;
			}

			if (count == 3) {
				return true;
			}
		}
		return false;
	}
}
