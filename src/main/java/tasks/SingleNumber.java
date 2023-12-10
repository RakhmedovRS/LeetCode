package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11-Mar-20
 */
@LeetCode(
		id = 136,
		name = "Single Number",
		url = "https://leetcode.com/problems/single-number/",
		difficulty = Difficulty.EASY
)
public class SingleNumber {
	public int singleNumber(int[] nums) {
		int a = 0;
		for (int num : nums) {
			a ^= num;
		}
		return a;
	}
}
