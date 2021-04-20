package tasks;

import common.LeetCode;
import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 09-Jul-20
 */
@LeetCode(id = 662, name = "Maximum Width of Binary Tree", url = "https://leetcode.com/problems/maximum-width-of-binary-tree/")
public class MaximumWidthOfBinaryTree
{
	public int widthOfBinaryTree(TreeNode root)
	{
		if (root == null)
		{
			return 0;
		}

		int[] max = new int[]{1};
		helper(root, 0, 1, new LinkedList<>(), max);
		return max[0];
	}

	public void helper(TreeNode root, int level, int index, List<Integer> list, int[] max)
	{
		if (root == null)
		{
			return;
		}
		if (level == list.size())
		{
			list.add(index);
		}
		max[0] = Math.max(max[0], index + 1 - list.get(level));
		helper(root.left, level + 1, index * 2, list, max);
		helper(root.right, level + 1, index * 2 + 1, list, max);
	}
}
