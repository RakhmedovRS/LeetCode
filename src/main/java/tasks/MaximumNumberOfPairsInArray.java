package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 7/17/2022
 */
@LeetCode(
		id = 2341,
		name = "Maximum Number of Pairs in Array",
		url = "https://leetcode.com/problems/maximum-number-of-pairs-in-array/",
		difficulty = Difficulty.EASY
)
public class MaximumNumberOfPairsInArray {
	public int[] numberOfPairs(int[] nums) {
		int[] memo = new int[101];
		for (int num : nums) {
			memo[num]++;
		}

		int[] answer = new int[2];

		for (int count : memo) {
			answer[0] += count / 2;
			answer[1] += count % 2;
		}

		return answer;
	}
}
