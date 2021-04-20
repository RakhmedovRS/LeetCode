package tasks;

import common.LeetCode;
import common.TreeNode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 07-Apr-20
 */
@LeetCode(id = 103, name = "Binary Tree Zigzag Level Order Traversal", url = "https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/")
public class BinaryTreeZigzagLevelOrderTraversal
{
	public List<List<Integer>> zigzagLevelOrder(TreeNode root)
	{
		Map<Integer, LinkedList<Integer>> zigzag = new HashMap<>();
		int level = 1;
		traverse(root, level, zigzag);
		List<List<Integer>> answer = new ArrayList<>();
		while (zigzag.containsKey(level))
		{
			answer.add(zigzag.get(level++));
		}
		return answer;
	}

	private void traverse(TreeNode root, int level, Map<Integer, LinkedList<Integer>> zigzag)
	{
		if (root == null)
		{
			return;
		}

		LinkedList<Integer> currentLevel = zigzag.getOrDefault(level, new LinkedList<>());

		if (level % 2 == 0)
		{
			currentLevel.addFirst(root.val);
		}
		else
		{
			currentLevel.addLast(root.val);
		}

		zigzag.put(level, currentLevel);

		traverse(root.left, level + 1, zigzag);
		traverse(root.right, level + 1, zigzag);
	}
}
