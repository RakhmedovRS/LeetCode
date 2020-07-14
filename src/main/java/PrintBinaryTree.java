import common.LeetCode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 14-Jul-20
 */
@LeetCode(id = 655, name = "Print Binary Tree", url = "https://leetcode.com/problems/print-binary-tree/")
public class PrintBinaryTree
{
	public List<List<String>> printTree(TreeNode root)
	{
		int maxDepth = getMaxDepth(root);

		List<List<String>> levels = new ArrayList<>();
		int levelSize = (int) Math.pow(2, maxDepth) - 1;
		for (int i = 0; i < maxDepth; i++)
		{
			List<String> level = new ArrayList<>();
			for (int pos = 0; pos < levelSize; pos++)
			{
				level.add("");
			}
			levels.add(level);
		}

		fillLevels(root, 0, levelSize, 0, levels);

		return levels;
	}

	private void fillLevels(TreeNode treeNode, int left, int right, int level, List<List<String>> levels)
	{
		if (treeNode == null)
		{
			return;
		}

		levels.get(level).set((left + right) / 2, String.valueOf(treeNode.val));
		fillLevels(treeNode.left, left, (left + right) / 2, level + 1, levels);
		fillLevels(treeNode.right, (left + right + 1) / 2, right, level + 1, levels);
	}

	private int getMaxDepth(TreeNode treeNode)
	{
		if (treeNode == null)
		{
			return 0;
		}

		return 1 + Math.max(getMaxDepth(treeNode.left), getMaxDepth(treeNode.right));
	}
}
