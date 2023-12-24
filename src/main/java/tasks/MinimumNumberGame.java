package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 12/23/2023
 */
@LeetCode(
		id = 2974,
		name = "Minimum Number Game",
		url = "https://leetcode.com/problems/minimum-number-game/",
		difficulty = Difficulty.EASY
)
public class MinimumNumberGame {
	public int[] numberGame(int[] nums) {
		Arrays.sort(nums);
		int[] res = new int[nums.length];

		int resPos = 0;
		int alice = 0;
		int bob = 1;
		while (alice < nums.length || bob < nums.length) {
			if (bob < nums.length) {
				res[resPos++] = nums[bob];
				bob += 2;
			}

			if (alice < nums.length) {
				res[resPos++] = nums[alice];
				alice += 2;
			}
		}

		return res;
	}
}
