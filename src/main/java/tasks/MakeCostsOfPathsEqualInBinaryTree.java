package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 5/7/2023
 */
@LeetCode(
		id = 2673,
		name = "Make Costs of Paths Equal in a Binary Tree",
		url = "https://leetcode.com/problems/make-costs-of-paths-equal-in-a-binary-tree/",
		difficulty = Difficulty.MEDIUM
)
public class MakeCostsOfPathsEqualInBinaryTree {
	public int minIncrements(int n, int[] cost) {
		int[] ans = new int[]{0};
		dfs(0, cost, ans);
		return ans[0];
	}

	private int dfs(int pos, int[] cost, int[] res) {
		if (pos >= cost.length) {
			return 0;
		}

		int left = dfs(pos * 2 + 1, cost, res);
		int right = dfs(pos * 2 + 2, cost, res);

		res[0] += Math.abs(left - right);

		return Math.max(left, right) + cost[pos];
	}
}
