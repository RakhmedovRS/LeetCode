package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 27-Jun-20
 */
@LeetCode(
	id = 897,
	name = "Increasing Order Search Tree",
	url = "https://leetcode.com/problems/increasing-order-search-tree/",
	difficulty = Difficulty.EASY
)
public class IncreasingOrderSearchTree
{
	public TreeNode increasingBST(TreeNode root)
	{
		if (root == null)
		{
			return null;
		}

		List<TreeNode> queue = new ArrayList<>();
		inorder(root, queue);
		TreeNode prev;
		TreeNode curr;
		for (int i = 1; i < queue.size(); i++)
		{
			prev = queue.get(i - 1);
			curr = queue.get(i);

			prev.left = null;
			curr.left = null;
			curr.right = null;

			prev.right = curr;
		}


		return queue.get(0);
	}

	private void inorder(TreeNode root, List<TreeNode> queue)
	{
		if (root == null)
		{
			return;
		}

		inorder(root.left, queue);
		queue.add(root);
		inorder(root.right, queue);
	}

	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(1);
		root.right = new TreeNode(6);
		root.right.right = new TreeNode(8);
		root.right.right.left = new TreeNode(7);
		root.right.right.right  = new TreeNode(9);

		new IncreasingOrderSearchTree().increasingBST(root);
	}
}
