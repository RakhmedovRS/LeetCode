import common.LeetCode;
import common.TreeNode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 24-Aug-20
 */
@LeetCode(id = 998, name = "Maximum Binary Tree II", url = "https://leetcode.com/problems/maximum-binary-tree-ii/")
public class MaximumBinaryTreeII
{
	public TreeNode insertIntoMaxTree(TreeNode root, int val)
	{
		LinkedList<Integer> nodes = getNodes(root);
		nodes.addLast(val);
		Integer[] ints = nodes.toArray(new Integer[0]);
		return buildTree(ints, 0, ints.length - 1);
	}

	private TreeNode buildTree(Integer[] ints, int left, int right)
	{
		if (left > right)
		{
			return null;
		}

		if (left == right)
		{
			return new TreeNode(ints[left]);
		}

		int idx = left;
		for (int i = left; i <= right; i++)
		{
			if (ints[i] > ints[idx])
			{
				idx = i;
			}
		}

		TreeNode node = new TreeNode(ints[idx]);
		node.left = buildTree(ints, left, idx - 1);
		node.right = buildTree(ints, idx + 1, right);
		return node;
	}

	private LinkedList<Integer> getNodes(TreeNode root)
	{
		if (root == null)
		{
			return new LinkedList<>();
		}

		LinkedList<Integer> nodes = new LinkedList<>();
		nodes.add(root.val);
		LinkedList<Integer> lefts = getNodes(root.left);
		LinkedList<Integer> rights = getNodes(root.right);

		while (!lefts.isEmpty())
		{
			nodes.addFirst(lefts.removeLast());
		}

		for (Integer node : rights)
		{
			nodes.addLast(node);
		}

		return nodes;
	}
}
