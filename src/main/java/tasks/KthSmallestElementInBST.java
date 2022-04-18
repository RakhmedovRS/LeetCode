package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 08-Feb-20
 */
@LeetCode(
	id = 230,
	name = "Kth Smallest Element in a BST",
	url = "https://leetcode.com/problems/kth-smallest-element-in-a-bst/",
	difficulty = Difficulty.MEDIUM
)
public class KthSmallestElementInBST
{
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

	public int kthSmallest1(TreeNode root, int k)
	{
		LinkedList<Integer> values = new LinkedList<>();
		kthSmallest(root, values, k);
		return values.getLast();
	}

	public int kthSmallest(TreeNode root, int k)
	{
		Deque<TreeNode> deck = new LinkedList<>();

		if (root == null)
		{
			return 0;
		}
		deck.push(root);
		root = root.left;

		while (root != null || !deck.isEmpty())
		{
			if (root != null)
			{
				deck.push(root);
				root = root.left;
			}
			else
			{
				root = deck.poll();
				if (--k == 0)
				{
					return root.val;
				}
				root = root.right;
			}
		}
		return 1;
	}
}
