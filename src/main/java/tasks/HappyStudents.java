package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 9/16/2023
 */
@LeetCode(
		id = 2860,
		name = "Happy Students",
		url = "https://leetcode.com/problems/happy-students/",
		difficulty = Difficulty.MEDIUM
)
public class HappyStudents {
	public int countWays(List<Integer> nums) {
		nums.sort(null);
		int ways = nums.get(0) == 0 ? 0 : 1;
		int selected = 0;
		for (int i = 0; i < nums.size(); i++) {
			selected++;
			int n = nums.get(i);
			if (selected > n) {
				if (i + 1 < nums.size() && selected < nums.get(i + 1)) {
					ways++;
				}
			}
		}

		if (selected > nums.get(nums.size() - 1)) {
			ways++;
		}

		return ways;
	}
}
