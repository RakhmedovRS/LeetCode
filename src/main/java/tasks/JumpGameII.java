package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 18-Apr-20
 */
@LeetCode(
		id = 45,
		name = "Jump Game II",
		url = "https://leetcode.com/problems/jump-game-ii/",
		difficulty = Difficulty.MEDIUM
)
public class JumpGameII {
	public int jump(int[] nums) {
		Integer[] memo = new Integer[nums.length];
		memo[0] = 0;

		int jumps;
		for (int i = 0; i < nums.length; i++) {
			if (memo[i] == null) {
				continue;
			}

			jumps = memo[i] + 1;
			for (int j = i + 1; j <= Math.min(nums.length - 1, i + nums[i]); j++) {
				if (memo[j] == null) {
					memo[j] = jumps;
				}
				else {
					memo[j] = Math.min(memo[j], jumps);
				}
			}
		}

		return memo[memo.length - 1];
	}

	public static void main(String[] args) {
		System.out.println(new JumpGameII().jump(new int[]{
				8, 2, 4, 4, 4, 9, 5, 2, 5, 8, 8, 0, 8, 6, 9, 1,
				1, 6, 3, 5, 1, 2, 6, 6, 0, 4, 8, 6, 0, 3, 2, 8,
				7, 6, 5, 1, 7, 0, 3, 4, 8, 3, 5, 9, 0, 4, 0, 1,
				0, 5, 9, 2, 0, 7, 0, 2, 1, 0, 8, 2, 5, 1, 2, 3,
				9, 7, 4, 7, 0, 0, 1, 8, 5, 6, 7, 5, 1, 9, 9, 3,
				5, 0, 7, 5}));
	}
}
