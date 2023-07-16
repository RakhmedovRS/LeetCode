package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 20-Mar-20
 */
@LeetCode(
		id = 98,
		name = "Validate Binary Search Tree",
		url = "https://leetcode.com/problems/validate-binary-search-tree/",
		difficulty = Difficulty.MEDIUM
)
public class ValidateBinarySearchTree
{
	public boolean isValidBST(TreeNode root)
	{
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean isValidBST(TreeNode root, long min, long max)
	{
		if (root == null)
		{
			return true;
		}

		if (min < root.val && root.val < max)
		{
			return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
		}
		return false;
	}

	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		System.out.println(new ValidateBinarySearchTree().isValidBST(root));
		System.out.println(new ValidateBinarySearchTree().isValidBST(new TreeNode(Integer.MAX_VALUE)));
	}
}
