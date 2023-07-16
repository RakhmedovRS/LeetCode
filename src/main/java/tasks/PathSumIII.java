package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 08-Aug-20
 */
@LeetCode(
		id = 437,
		name = "Path Sum III",
		url = "https://leetcode.com/problems/path-sum-iii/",
		difficulty = Difficulty.MEDIUM
)
public class PathSumIII
{
	public int pathSum(TreeNode root, int sum)
	{
		Map<Integer, Integer> memo = new HashMap<>();
		memo.put(0, 1);
		return dfs(root, 0, sum, memo);
	}

	private int dfs(TreeNode root, int currentSum, int targetSum, Map<Integer, Integer> memo)
	{
		if (root == null)
		{
			return 0;
		}

		currentSum += root.val;

		int paths = memo.getOrDefault(currentSum - targetSum, 0);
		memo.put(currentSum, memo.getOrDefault(currentSum, 0) + 1);
		paths += dfs(root.left, currentSum, targetSum, memo);
		paths += dfs(root.right, currentSum, targetSum, memo);
		memo.put(currentSum, memo.get(currentSum) - 1);
		return paths;
	}
}
