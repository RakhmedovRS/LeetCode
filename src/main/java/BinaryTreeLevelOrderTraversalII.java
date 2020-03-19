import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 19-Mar-20
 */
@LeetCode(id = 107, name = "Binary Tree Level Order Traversal II",
	url = "https://leetcode.com/problems/binary-tree-level-order-traversal-ii/")
public class BinaryTreeLevelOrderTraversalII
{
	public class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x){ val = x; }
	}

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
