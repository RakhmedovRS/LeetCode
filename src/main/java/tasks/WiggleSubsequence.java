package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 10-Aug-20
 */
@LeetCode(
		id = 376,
		name = "Wiggle Subsequence",
		url = "https://leetcode.com/problems/wiggle-subsequence/",
		difficulty = Difficulty.MEDIUM
)
public class WiggleSubsequence {
	public int wiggleMaxLength(int[] nums) {
		int maxLen = 1;
		if (nums.length < 1) {
			return 0;
		}

		List<int[]> list = new ArrayList<>();
		list.add(new int[]{1, 1});

		for (int i = 1; i < nums.length; i++) {
			int[] res = new int[]{1, 1};
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					res[0] = Math.max(res[0], list.get(j)[1] + 1);
					res[1] = Math.max(res[1], list.get(j)[1]);
				}
				else if (nums[j] > nums[i]) {
					res[1] = Math.max(res[1], list.get(j)[0] + 1);
					res[0] = Math.max(res[0], list.get(j)[0]);
				}
			}

			list.add(res);
			maxLen = Math.max(maxLen, Math.max(res[0], res[1]));
		}

		return maxLen;
	}
}
