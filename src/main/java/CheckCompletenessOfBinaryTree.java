import common.LeetCode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 01-Jun-20
 */
@LeetCode(id = 958, name = "Check Completeness of a Binary Tree", url = "https://leetcode.com/problems/check-completeness-of-a-binary-tree/")
public class CheckCompletenessOfBinaryTree
{
	public boolean isCompleteTree(TreeNode root)
	{
		if (root == null)
		{
			return true;
		}

		Map<Integer, List<Integer>> levels = new HashMap<>();
		int depth = treeDepth(root, 1, levels);

		for (int i = 1; i <= depth; i++)
		{
			List<Integer> level = levels.get(i);
			for (int idx = 1; idx < level.size(); idx++)
			{
				if (i != depth)
				{
					if (level.get(idx) == null || level.get(idx - 1) == null)
					{
						return false;
					}
				}
				else
				{
					if (level.get(idx) != null && level.get(idx - 1) == null)
					{
						return false;
					}
				}

			}
		}

		return true;
	}

	private int treeDepth(TreeNode root, int depth, Map<Integer, List<Integer>> levels)
	{
		List<Integer> level = levels.getOrDefault(depth, new ArrayList<>());

		if (root == null)
		{
			level.add(null);
			levels.put(depth, level);
			return 0;
		}

		level.add(root.val);
		levels.put(depth, level);

		return 1 + Math.max(treeDepth(root.left, depth + 1, levels),
			treeDepth(root.right, depth + 1, levels));
	}
}
