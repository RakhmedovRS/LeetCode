import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 21-Feb-20
 */
@LeetCode(id = 124, name = "Binary Tree Maximum Path Sum", url = "https://leetcode.com/problems/binary-tree-maximum-path-sum/")
public class BinaryTreeMaximumPathSum
{
	public class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x){ val = x; }
	}

	private int maxPathSum = Integer.MIN_VALUE;

	public int max(TreeNode treeNode)
	{
		if (treeNode == null)
		{
			return 0;
		}

		int left = Math.max(0, max(treeNode.left));
		int right = Math.max(0, max(treeNode.right));

		maxPathSum = Math.max(maxPathSum, left + right + treeNode.val);
		return Math.max(left, right) + treeNode.val;
	}

	public int maxPathSum(TreeNode root)
	{
		max(root);
		return maxPathSum;
	}
}
