package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 11/21/2022
 */
@LeetCode(
		id = 2471,
		name = "Minimum Number of Operations to Sort a Binary Tree by Level",
		url = "https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumNumberOfOperationsToSortBinaryTreeByLevel
{
	public int minimumOperations(TreeNode root)
	{
		Map<Integer, List<Integer>> levels = new HashMap<>();
		dfs(0, root, levels);
		int ops = 0;
		int level = 1;
		while (levels.containsKey(level))
		{
			List<Integer> origin = levels.get(level);
			Map<Integer, Integer> valueToIndex = new HashMap<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
			for (int i = 0; i < origin.size(); i++)
			{
				valueToIndex.put(origin.get(i), i);
				pq.add(origin.get(i));
			}

			for (int i = 0; i < origin.size(); i++)
			{
				if (!origin.get(i).equals(origin.get(valueToIndex.get(pq.peek()))))
				{
					int val = pq.remove();
					int index = valueToIndex.remove(val);
					int a = origin.get(i);

					origin.set(i, val);
					origin.set(index, a);

					valueToIndex.put(a, index);

					ops++;
				}
				else if (origin.get(i).equals(origin.get(valueToIndex.get(pq.peek()))))
				{
					pq.remove();
				}
			}

			level++;
		}


		return ops;
	}

	private void dfs(int level, TreeNode root, Map<Integer, List<Integer>> levels)
	{
		if (root == null)
		{
			return;
		}

		levels.putIfAbsent(level, new ArrayList<>());
		levels.get(level).add(root.val);
		dfs(level + 1, root.left, levels);
		dfs(level + 1, root.right, levels);
	}
}
