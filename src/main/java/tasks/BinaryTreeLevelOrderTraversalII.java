package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 19-Mar-20
 */
@LeetCode(
		id = 107,
		name = "Binary Tree Level Order Traversal II",
		url = "https://leetcode.com/problems/binary-tree-level-order-traversal-ii/",
		difficulty = Difficulty.MEDIUM
)
public class BinaryTreeLevelOrderTraversalII
{
	public List<List<Integer>> levelOrderBottom(TreeNode root)
	{
		Map<Integer, List<Integer>> cache = new HashMap<>();
		levelOrderBottom(root, cache, 1);

		int i = 1;
		LinkedList<List<Integer>> result = new LinkedList<>();
		while (cache.containsKey(i))
		{
			result.addFirst(cache.get(i));
			i++;
		}

		return result;
	}

	private void levelOrderBottom(TreeNode root, Map<Integer, List<Integer>> cache, int level)
	{
		if (root == null)
		{
			return;
		}

		List<Integer> list = cache.getOrDefault(level, new ArrayList<>());
		list.add(root.val);
		cache.put(level, list);

		levelOrderBottom(root.left, cache, level + 1);
		levelOrderBottom(root.right, cache, level + 1);
	}
}
