package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 17-May-20
 */
@LeetCode(
		id = 701,
		name = "Insert into a Binary Search Tree",
		url = "https://leetcode.com/problems/insert-into-a-binary-search-tree/",
		difficulty = Difficulty.MEDIUM
)
public class InsertIntoBinarySearchTree
{
	public TreeNode insertIntoBST(TreeNode root, int val)
	{
		if (root == null)
		{
			return new TreeNode(val);
		}

		if (val > root.val)
		{
			root.right = insertIntoBST(root.right, val);
		}
		else if (val < root.val)
		{
			root.left = insertIntoBST(root.left, val);
		}

		return root;
	}

	public static void main(String[] args)
	{

	}
}
