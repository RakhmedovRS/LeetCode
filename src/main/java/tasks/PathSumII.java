package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 8/4/2021
 */
@LeetCode(
		id = 113,
		name = "Path Sum II",
		url = "https://leetcode.com/problems/path-sum-ii/",
		difficulty = Difficulty.MEDIUM
)
public class PathSumII
{
	public List<List<Integer>> pathSum(TreeNode root, int targetSum)
	{
		List<List<Integer>> answer = new ArrayList<>();
		LinkedList<Integer> current = new LinkedList<>();
		dfs(root, targetSum, current, answer);
		return answer;
	}

	private void dfs(TreeNode root, int targetSum, LinkedList<Integer> current, List<List<Integer>> answer)
	{
		if (root == null)
		{
			return;
		}

		current.addLast(root.val);

		targetSum -= root.val;
		if (root.left == null && root.right == null && targetSum == 0)
		{
			answer.add(new ArrayList<>(current));
		}

		dfs(root.left, targetSum, current, answer);
		dfs(root.right, targetSum, current, answer);

		current.removeLast();
	}
}
