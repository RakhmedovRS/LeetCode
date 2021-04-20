package tasks;

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
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K)
	{
		List<Integer> answer = new ArrayList<>();
		Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
		buildGraph(root, null, graph);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(target);
		int currentDistance = 0;
		int levelSize;
		TreeNode current;
		Set<TreeNode> visited = new HashSet<>();
		while (!queue.isEmpty() && currentDistance <= K)
		{
			levelSize = queue.size();
			while (levelSize-- > 0)
			{
				current = queue.remove();
				if (!visited.add(current))
				{
					continue;
				}

				if (currentDistance == K)
				{
					answer.add(current.val);
				}

				queue.addAll(graph.getOrDefault(current, Collections.emptyList()));
			}

			currentDistance++;
		}


		return answer;
	}

	private void buildGraph(TreeNode root, TreeNode prev, Map<TreeNode, List<TreeNode>> graph)
	{
		if (root == null)
		{
			return;
		}

		graph.putIfAbsent(root, new ArrayList<>());

		if (prev != null)
		{
			graph.get(root).add(prev);
		}

		if (root.left != null)
		{
			graph.get(root).add(root.left);
		}

		if (root.right != null)
		{
			graph.get(root).add(root.right);
		}

		buildGraph(root.left, root, graph);
		buildGraph(root.right, root, graph);
	}
}
