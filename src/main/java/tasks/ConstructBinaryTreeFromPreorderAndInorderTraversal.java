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
		int[] pos = new int[]{0};

		return buildTree(preorder, inorder, pos, 0, preorder.length - 1);
	}

	private TreeNode buildTree(int[] preorder, int[] inorder, int[] pos, int left, int right)
	{
		if (left > right)
		{
			return null;
		}

		TreeNode treeNode = new TreeNode(preorder[pos[0]++]);
		for (int i = left; i <= right; i++)
		{
			if (inorder[i] == treeNode.val)
			{
				treeNode.left = buildTree(preorder, inorder, pos, left, i - 1);
				treeNode.right = buildTree(preorder, inorder, pos, i + 1, right);
				break;
			}
		}

		return treeNode;
	}
}
