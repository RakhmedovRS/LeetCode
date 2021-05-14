package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 5/14/2021
 */
@LeetCode(
	id = 114,
	name = "Flatten Binary Tree to Linked List",
	url = "https://leetcode.com/problems/flatten-binary-tree-to-linked-list/",
	difficulty = Difficulty.MEDIUM
)
public class FlattenBinaryTreeToLinkedList
{
	public void flatten(TreeNode root)
	{
		dfs(root);
	}

	public TreeNode dfs(TreeNode root)
	{
		if (root == null)
		{
			return null;
		}

		TreeNode right = root.right;

		TreeNode leftList = dfs(root.left);
		root.left = null;

		root.right = leftList;

		TreeNode end = root;
		while (end.right != null)
		{
			end = end.right;
		}

		end.right = dfs(right);

		return root;
	}
}
