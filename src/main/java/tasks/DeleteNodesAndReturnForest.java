package tasks;

import common.LeetCode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 22-Jun-20
 */
@LeetCode(id = 1110, name = "Delete Nodes And Return Forest", url = "https://leetcode.com/problems/delete-nodes-and-return-forest/")
public class DeleteNodesAndReturnForest
{
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete)
	{
		Set<Integer> toDelete = new HashSet<>();
		for (int num : to_delete)
		{
			toDelete.add(num);
		}

		List<TreeNode> subtrees = new ArrayList<>();
		if (!toDelete.contains(root.val))
		{
			subtrees.add(root);
		}

		delNodes(root, toDelete, subtrees);
		return subtrees;
	}

	private void delNodes(TreeNode root, Set<Integer> toDelete, List<TreeNode> subtrees)
	{
		if (root == null)
		{
			return;
		}

		TreeNode left = root.left;
		TreeNode right = root.right;

		if (left != null && toDelete.contains(left.val))
		{
			root.left = null;
		}

		if (right != null && toDelete.contains(right.val))
		{
			root.right = null;
		}

		if (toDelete.contains(root.val))
		{
			if (left != null && !toDelete.contains(left.val))
			{
				subtrees.add(left);
			}

			if (right != null && !toDelete.contains(right.val))
			{
				subtrees.add(right);
			}
		}

		delNodes(left, toDelete, subtrees);
		delNodes(right, toDelete, subtrees);
	}
}
