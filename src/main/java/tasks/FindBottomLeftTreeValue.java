package tasks;

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
@LeetCode(id = 513, name = "Find Bottom Left Tree Value", url = "https://leetcode.com/problems/find-bottom-left-tree-value/")
public class FindBottomLeftTreeValue
{
	public int findBottomLeftValue(TreeNode root)
	{
		int answer = root.val;
		Map<Integer, List<Integer>> levels = new HashMap<>();
		findBottomLeftValue(root, 1, levels);
		int level = 1;
		while (levels.containsKey(level))
		{
			List<Integer> list = levels.get(level++);
			for (Integer entry : list)
			{
				if (entry != null)
				{
					answer = entry;
					break;
				}
			}
		}

		return answer;
	}

	public void findBottomLeftValue(TreeNode root, int level, Map<Integer, List<Integer>> levels)
	{
		if (root == null)
		{
			return;
		}

		List<Integer> l = levels.getOrDefault(level, new ArrayList<>());
		l.add(root.val);
		levels.put(level, l);

		findBottomLeftValue(root.left, level + 1, levels);
		findBottomLeftValue(root.right, level + 1, levels);
	}
}
