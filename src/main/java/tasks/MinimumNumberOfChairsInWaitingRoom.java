package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-06-01
 */
@LeetCode(
		id = 3168,
		name = "Minimum Number of Chairs in a Waiting Room",
		url = "https://leetcode.com/problems/minimum-number-of-chairs-in-a-waiting-room/description/",
		difficulty = Difficulty.EASY
)
public class MinimumNumberOfChairsInWaitingRoom {
	public int minimumChairs(String s) {
		int max = 0;
		int curr = 0;
		for (char ch : s.toCharArray()) {
			if (ch == 'E') {
				curr++;
			} else {
				curr--;
			}
			max = Math.max(max, curr);
		}
		return max;
	}
}