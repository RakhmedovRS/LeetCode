package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/22/2020
 */
@LeetCode(
		id = 660,
		name = "Remove 9",
		url = "https://leetcode.com/problems/remove-9/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class Remove9 {
	public int newInteger(int n) {
		return Integer.parseInt(Integer.toString(n, 9));
	}
}
