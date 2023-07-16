package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 3/8/2023
 */
@LeetCode(
		id = 2583,
		name = "Kth Largest Sum in a Binary Tree",
		url = "https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/",
		difficulty = Difficulty.MEDIUM
)
public class KthLargestSumInBinaryTree
{
	public long kthLargestLevelSum(TreeNode root, int k)
	{
		Map<Integer, Long> map = new HashMap<>();
		dfs(root, 1, map);

		List<Integer> levels = new ArrayList<>(map.keySet());
		if (levels.size() < k)
		{
			return -1;
		}

		levels.sort((a, b) -> Long.compare(map.getOrDefault(b, 0L), map.getOrDefault(a, 0L)));
		return map.get(levels.get(k - 1));
	}

	private void dfs(TreeNode root, int level, Map<Integer, Long> map)
	{
		if (root == null)
		{
			return;
		}

		map.put(level, map.getOrDefault(level, 0L) + root.val);
		dfs(root.left, level + 1, map);
		dfs(root.right, level + 1, map);
	}
}
