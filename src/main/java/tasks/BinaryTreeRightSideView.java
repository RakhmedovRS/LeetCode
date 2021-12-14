package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 02-May-20
 */
@LeetCode(
	id = 199,
	name = "Binary Tree Right Side View",
	url = "https://leetcode.com/problems/binary-tree-right-side-view/",
	difficulty = Difficulty.MEDIUM
)
public class BinaryTreeRightSideView
{
	public List<Integer> rightSideView(TreeNode root)
	{
		List<Integer> result = new ArrayList<>();
		if (root == null)
		{
			return result;
		}

		Map<Integer, Boolean> visited = new HashMap<>();
		rightSideView(root, result, visited, 1);

		return result;
	}

	private void rightSideView(TreeNode root, List<Integer> result, Map<Integer, Boolean> visited, int currentLevel)
	{
		if (root == null)
		{
			return;
		}

		if (!visited.getOrDefault(currentLevel, false))
		{
			visited.put(currentLevel, true);
			result.add(root.val);
		}
		rightSideView(root.right, result, visited, currentLevel + 1);
		rightSideView(root.left, result, visited, currentLevel + 1);
	}
}
