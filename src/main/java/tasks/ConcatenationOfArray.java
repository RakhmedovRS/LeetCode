package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 7/12/2021
 */
@LeetCode(
		id = 1929,
		name = "Concatenation of Array",
		url = "https://leetcode.com/problems/concatenation-of-array/",
		difficulty = Difficulty.EASY
)
public class ConcatenationOfArray {
	public int[] getConcatenation(int[] nums) {
		int[] answer = new int[nums.length * 2];
		for (int i = 0; i < nums.length; i++) {
			answer[i] = nums[i];
			answer[i + nums.length] = nums[i];
		}

		return answer;
	}
}
