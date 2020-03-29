import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 08-Feb-20
 */
@LeetCode(id = 230, name = "Kth Smallest Element in a BST", url = "https://leetcode.com/problems/kth-smallest-element-in-a-bst/")
public class KthSmallestElementInBST
{
	public static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x){ val = x; }
	}

	public void kthSmallest(TreeNode root, LinkedList<Integer> values, int k)
	{
		if (root == null)
		{
			return;
		}

		if (values.size() == k)
		{
			return;
		}

		if (root.left == null && root.right == null)
		{
			values.add(root.val);
			return;
		}

		kthSmallest(root.left, values, k);
		if (values.size() == k)
		{
			return;
		}
		else
		{
			values.add(root.val);
		}
		kthSmallest(root.right, values, k);
	}

	public int kthSmallest(TreeNode root, int k)
	{
		LinkedList<Integer> values = new LinkedList<>();
		kthSmallest(root, values, k);
		return values.getLast();
	}
}
