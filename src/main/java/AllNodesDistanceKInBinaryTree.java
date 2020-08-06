import common.LeetCode;
import common.TreeNode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 06-Aug-20
 */
@LeetCode(id = 863, name = "All Nodes Distance K in Binary Tree", url = "https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/")
public class AllNodesDistanceKInBinaryTree
{
	public List<Integer> distanceK(TreeNode root, TreeNode target, int distance)
	{
		if (target == null || root == null)
		{
			return Collections.emptyList();
		}

		if (distance == 0)
		{
			return Arrays.asList(target.val);
		}

		Map<Integer, List<Integer>> graph = new HashMap<>();
		fillInTheGraph(root, null, graph);
		if (!graph.containsKey(target.val))
		{
			return Collections.emptyList();
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(target.val);
		int size;
		Set<Integer> visited = new HashSet<>();
		while (!queue.isEmpty())
		{
			size = queue.size();
			while (size-- > 0)
			{
				int current = queue.remove();
				if (!visited.add(current))
				{
					continue;
				}

				for (int next : graph.getOrDefault(current, Collections.emptyList()))
				{
					if (!visited.contains(next))
					{
						queue.add(next);
					}
				}
			}

			distance--;
			if (distance == 0)
			{
				return new ArrayList<>(queue);
			}
		}

		return Collections.emptyList();
	}

	private void fillInTheGraph(TreeNode root, TreeNode parent, Map<Integer, List<Integer>> graph)
	{
		if (root == null)
		{
			return;
		}

		if (parent != null)
		{
			graph.putIfAbsent(parent.val, new ArrayList<>());
			graph.putIfAbsent(root.val, new ArrayList<>());
			graph.get(parent.val).add(root.val);
			graph.get(root.val).add(parent.val);
		}

		fillInTheGraph(root.left, root, graph);
		fillInTheGraph(root.right, root, graph);
	}
}
