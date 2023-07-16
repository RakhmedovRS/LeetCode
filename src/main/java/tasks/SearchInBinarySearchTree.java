package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 10-Feb-20
 */
@LeetCode(
		id = 700,
		name = "Search in a Binary Search Tree",
		url = "https://leetcode.com/problems/search-in-a-binary-search-tree/",
		difficulty = Difficulty.EASY
)
public class SearchInBinarySearchTree
{
	public TreeNode searchBST(TreeNode root, int val)
	{
		if (root == null || root.val == val)
		{
			return root;
		}

		if (root.val > val)
		{
			return searchBST(root.left, val);
		}

		return searchBST(root.right, val);
	}
}
