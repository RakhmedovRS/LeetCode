package tasks;

import common.LeetCode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 10/4/2020
 */
@LeetCode(id = 1609, name = "Even Odd Tree", url = "https://leetcode.com/problems/even-odd-tree/")
public class EvenOddTree
{
	public boolean isEvenOddTree(TreeNode root)
	{
		Map<Integer, List<Integer>> levelMap = new HashMap<>();
		if (!inOrder(root, 0, levelMap))
		{
			return false;
		}

		int level = 0;
		List<Integer> levelNodes;
		while (levelMap.containsKey(level))
		{
			levelNodes = levelMap.get(level);
			if (level % 2 == 0)
			{
				for (int i = 1; i < levelNodes.size(); i++)
				{
					if (levelNodes.get(i - 1) >= levelNodes.get(i))
					{
						return false;
					}
				}
			}
			else
			{
				for (int i = levelNodes.size() - 1; i > 0; i--)
				{
					if (levelNodes.get(i - 1) <= levelNodes.get(i))
					{
						return false;
					}
				}
			}

			level++;
		}

		return true;
	}

	private boolean inOrder(TreeNode root, int level, Map<Integer, List<Integer>> levelMap)
	{
		if (root == null)
		{
			return true;
		}

		levelMap.putIfAbsent(level, new ArrayList<>());
		levelMap.get(level).add(root.val);

		if (level % 2 == 0)
		{
			return root.val % 2 != 0 && inOrder(root.left, level + 1, levelMap) && inOrder(root.right, level + 1, levelMap);
		}
		else
		{
			return root.val % 2 == 0 && inOrder(root.left, level + 1, levelMap) && inOrder(root.right, level + 1, levelMap);
		}
	}
}
