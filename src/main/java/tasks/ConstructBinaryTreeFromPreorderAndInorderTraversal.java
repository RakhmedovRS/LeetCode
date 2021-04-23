package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 08-Apr-20
 */
@LeetCode(
	id = 105,
	name = "Construct Binary Tree from Preorder and Inorder Traversal",
	url = "https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/",
	difficulty = Difficulty.MEDIUM
)
public class ConstructBinaryTreeFromPreorderAndInorderTraversal
{
	public TreeNode buildTree(int[] preorder, int[] inorder)
	{
		int[] memo = new int[6002];
		for (int i = 0; i < inorder.length; i++)
		{
			memo[inorder[i] + 3000] = i;
		}

		return buildTree(preorder, new int[]{0}, 0, inorder.length - 1, memo);
	}

	private TreeNode buildTree(int[] preOrder, int[] preOrderPos, int left, int right, int[] memo)
	{
		if (preOrderPos[0] >= preOrder.length || left > right)
		{
			return null;
		}

		TreeNode node = new TreeNode(preOrder[preOrderPos[0]++]);
		node.left = buildTree(preOrder, preOrderPos, left, memo[node.val + 3000] - 1, memo);
		node.right = buildTree(preOrder, preOrderPos, memo[node.val + 3000] + 1, right, memo);

		return node;
	}
}
