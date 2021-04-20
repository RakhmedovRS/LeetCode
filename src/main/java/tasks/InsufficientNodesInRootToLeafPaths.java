package tasks;

import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 30-Jul-20
 */
@LeetCode(id = 1080, name = "Insufficient Nodes in Root to Leaf Paths", url = "https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/")
public class InsufficientNodesInRootToLeafPaths
{
	public TreeNode sufficientSubset(TreeNode root, int limit)
	{
		return dfs(root, limit, 0);
	}

	private TreeNode dfs(TreeNode root, int limit, int sum)
	{
		if (root == null)
		{
			return null;
		}

		sum += root.val;

		if (root.left == null && root.right == null)
		{
			return sum < limit ? null : root;
		}

		root.left = dfs(root.left, limit, sum);
		root.right = dfs(root.right, limit, sum);

		return root.left == null && root.right == null ? null : root;
	}
}
