package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 3/5/2022
 */
@LeetCode(
		id = 2190,
		name = "Most Frequent Number Following Key In an Array",
		url = "https://leetcode.com/contest/biweekly-contest-73/problems/most-frequent-number-following-key-in-an-array/",
		difficulty = Difficulty.EASY
)
public class MostFrequentNumberFollowingKeyInArray {
	public int mostFrequent(int[] nums, int key) {
		int[] memo = new int[1001];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == key && i + 1 < nums.length) {
				memo[nums[i + 1]]++;
			}
		}

		int max = 0;
		int answer = 0;
		for (int i = 0; i < memo.length; i++) {
			if (memo[i] > max) {
				max = memo[i];
				answer = i;
			}
		}

		return answer;
	}
}
