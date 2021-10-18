package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 10/18/2021
 */
@LeetCode(
	id = 993,
	name = "Cousins in Binary Tree",
	url = "https://leetcode.com/problems/cousins-in-binary-tree/",
	difficulty = Difficulty.EASY
)
public class CousinsInBinaryTree
{
	public boolean isCousins(TreeNode root, int x, int y)
	{
		int[] xParent = new int[1];
		int[] xLevel = new int[1];

		int[] yParent = new int[1];
		int[] yLevel = new int[1];

		dfs(0, -1, root, x, y, xParent, yParent, xLevel, yLevel);

		return xLevel[0] == yLevel[0] && xParent[0] != yParent[0];
	}

	private void dfs(int level, int parent, TreeNode root, int x, int y, int[] xParent, int[] yParent, int[] xLevel, int[] yLevel)
	{
		if (root == null)
		{
			return;
		}

		if (root.val == x)
		{
			xLevel[0] = level;
			xParent[0] = parent;
		}

		if (root.val == y)
		{
			yLevel[0] = level;
			yParent[0] = parent;
		}

		dfs(level + 1, root.val, root.left, x, y, xParent, yParent, xLevel, yLevel);
		dfs(level + 1, root.val, root.right, x, y, xParent, yParent, xLevel, yLevel);
	}
}
