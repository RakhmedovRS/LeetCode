package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 10/14/2020
 */
@LeetCode(
		id = 337,
		name = "House Robber III",
		url = "https://leetcode.com/problems/house-robber-iii/",
		difficulty = Difficulty.MEDIUM
)
public class HouseRobberIII
{
	public int rob(TreeNode root)
	{
		Map<TreeNode, Integer[]> memo = new HashMap<>();
		return Math.max(dfs(root, 0, memo), dfs(root, 1, memo));
	}

	private int dfs(TreeNode root, int canRob, Map<TreeNode, Integer[]> memo)
	{
		if (root == null)
		{
			return 0;
		}

		if (memo.containsKey(root) && memo.get(root)[canRob] != null)
		{
			return memo.get(root)[canRob];
		}

		memo.putIfAbsent(root, new Integer[2]);

		if (canRob == 1)
		{
			memo.get(root)[canRob] = Math.max(root.val + dfs(root.left, 0, memo) + dfs(root.right, 0, memo),
					dfs(root.left, 1, memo) + dfs(root.right, 1, memo));
		}
		else
		{
			memo.get(root)[canRob] = dfs(root.left, 1, memo) + dfs(root.right, 1, memo);
		}

		return memo.get(root)[canRob];
	}
}
