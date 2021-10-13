package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 20-Apr-20
 */
@LeetCode(
	id = 1008,
	name = "Construct Binary Search Tree from Preorder Traversal",
	url = "https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/",
	difficulty = Difficulty.MEDIUM
)
public class ConstructBinarySearchTreeFromPreorderTraversal
{
	public TreeNode bstFromPreorder(int[] preorder)
	{
		return bstFromPreorder(preorder, new int[]{0}, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public TreeNode bstFromPreorder(int[] preorder, int[] idx, int min, int max)
	{
		if (idx[0] >= preorder.length)
		{
			return null;
		}

		TreeNode node = null;
		if (preorder[idx[0]] > min && preorder[idx[0]] < max)
		{
			node = new TreeNode(preorder[idx[0]]);
			idx[0] += 1;
			node.left = bstFromPreorder(preorder, idx, min, node.val);
			node.right = bstFromPreorder(preorder, idx, node.val, max);
		}

		return node;
	}
}
