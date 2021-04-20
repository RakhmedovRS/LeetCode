package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 12/10/2020
 */
@LeetCode(
	id = 742,
	name = "Closest Leaf in a Binary Tree",
	difficulty = Difficulty.MEDIUM,
	url = "https://leetcode.com/problems/closest-leaf-in-a-binary-tree/",
	premium = true
)
public class ClosestLeafInBinaryTree
{
	public int findClosestLeaf(TreeNode root, int k)
	{
		Map<Integer, List<Integer>> graph = new HashMap<>();
		buildGraph(null, root, graph);

		int size;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(k);
		int current;
		List<Integer> neighbors;
		Set<Integer> seen = new HashSet<>();
		while (!queue.isEmpty())
		{
			size = queue.size();
			while (size-- > 0)
			{
				current = queue.remove();
				neighbors = graph.get(current);
				if (neighbors.isEmpty() || current != root.val && neighbors.size() == 1)
				{
					return current;
				}

				for (int neighbor : graph.get(current))
				{
					if (seen.add(neighbor))
					{
						queue.add(neighbor);
					}
				}
			}
		}

		return root.val;
	}

	private void buildGraph(Integer parent, TreeNode root, Map<Integer, List<Integer>> graph)
	{
		if (root == null)
		{
			return;
		}

		List<Integer> neighbors = new ArrayList<>();
		if (parent != null)
		{
			neighbors.add(parent);
		}

		if (root.left != null)
		{
			neighbors.add(root.left.val);
		}

		if (root.right != null)
		{
			neighbors.add(root.right.val);
		}

		graph.put(root.val, neighbors);
		buildGraph(root.val, root.left, graph);
		buildGraph(root.val, root.right, graph);
	}
}
