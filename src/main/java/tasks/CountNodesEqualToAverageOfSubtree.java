package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 5/8/2022
 */
@LeetCode(
		id = 2265,
		name = "Count Nodes Equal to Average of Subtree",
		url = "https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/",
		difficulty = Difficulty.MEDIUM
)
public class CountNodesEqualToAverageOfSubtree
{
	public int averageOfSubtree(TreeNode root)
	{
		int[] arr = dfs(root);
		return arr[0];
	}

	private int[] dfs(TreeNode root)
	{
		if (root == null)
		{
			return new int[]{0, 0, 0};
		}

		int[] left = dfs(root.left);
		int[] right = dfs(root.right);

		int[] answer = new int[3];
		answer[0] = left[0] + right[0];
		answer[1] = 1 + left[1] + right[1];
		answer[2] = root.val + left[2] + right[2];

		if (answer[2] / answer[1] == root.val)
		{
			answer[0]++;
		}

		return answer;
	}
}
