import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 03-Apr-20
 */
@LeetCode(
		id = 987,
		name = "Vertical Order Traversal of a Binary Tree",
		url = "https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/",
		difficulty = Difficulty.HARD
)
public class VerticalOrderTraversalOfBinaryTree
{
	public List<List<Integer>> verticalTraversal(TreeNode root)
	{
		TreeMap<Integer, TreeMap<Integer, TreeSet<Integer>>> map = new TreeMap<>();
		dfs(root, 0, 0, map);

		List<Integer> keys = new ArrayList<>(map.keySet());
		keys.sort(null);

		List<List<Integer>> answer = new ArrayList<>();
		for (Map.Entry<Integer, TreeMap<Integer, TreeSet<Integer>>> entry : map.entrySet())
		{
			List<Integer> list = new ArrayList<>();
			for (Map.Entry<Integer, TreeSet<Integer>> e : entry.getValue().entrySet())
			{
				list.addAll(e.getValue());
			}

			answer.add(list);
		}

		return answer;
	}

	private void dfs(TreeNode root, int balance, int level, TreeMap<Integer, TreeMap<Integer, TreeSet<Integer>>> map)
	{
		if (root == null)
		{
			return;
		}

		map.putIfAbsent(balance, new TreeMap<>());
		map.get(balance).putIfAbsent(level, new TreeSet<>());
		map.get(balance).get(level).add(root.val);

		dfs(root.left, balance - 1, level + 1, map);
		dfs(root.right, balance + 1, level + 1, map);
	}
}
