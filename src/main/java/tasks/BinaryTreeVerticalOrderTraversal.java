package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 1/20/2021
 */
@LeetCode(
		id = 314,
		name = "Binary Tree Vertical Order Traversal",
		url = "https://leetcode.com/problems/binary-tree-vertical-order-traversal/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class BinaryTreeVerticalOrderTraversal
{
	public List<List<Integer>> verticalOrder(TreeNode root)
	{
		if (root == null)
		{
			return Collections.emptyList();
		}
		TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
		Queue<Map.Entry<Integer, TreeNode>> queue = new LinkedList<>();
		queue.add(new java.util.AbstractMap.SimpleEntry<>(0, root));
		int size;
		Map.Entry<Integer, TreeNode> current;
		TreeNode node;
		int balance;
		while (!queue.isEmpty())
		{
			size = queue.size();
			while (size-- > 0)
			{
				current = queue.remove();
				balance = current.getKey();
				node = current.getValue();
				treeMap.putIfAbsent(balance, new ArrayList<>());
				treeMap.get(current.getKey()).add(node.val);

				if (node.left != null)
				{
					queue.add(new java.util.AbstractMap.SimpleEntry<>(balance - 1, node.left));
				}

				if (node.right != null)
				{
					queue.add(new java.util.AbstractMap.SimpleEntry<>(balance + 1, node.right));
				}
			}
		}

		return new ArrayList<>(treeMap.values());
	}
}
