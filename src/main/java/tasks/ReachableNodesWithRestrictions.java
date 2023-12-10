package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 8/12/2022
 * @Ruslan Rakhmedov$
 * @1.0$
 */
@LeetCode(
		id = 2368,
		name = "Reachable Nodes With Restrictions",
		url = "https://leetcode.com/problems/reachable-nodes-with-restrictions/",
		difficulty = Difficulty.MEDIUM
)
public class ReachableNodesWithRestrictions {
	public int reachableNodes(int n, int[][] edges, int[] restricted) {
		int max = 0;
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] edge : edges) {
			int nodeA = edge[0];
			int nodeB = edge[1];

			graph.putIfAbsent(nodeA, new ArrayList<>());
			graph.putIfAbsent(nodeB, new ArrayList<>());

			graph.get(nodeA).add(nodeB);
			graph.get(nodeB).add(nodeA);
		}

		boolean[] visited = new boolean[n + 1];
		for (int rest : restricted) {
			visited[rest] = true;
		}
		visited[0] = true;

		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		while (!queue.isEmpty()) {
			int node = queue.remove();

			max++;

			for (int next : graph.getOrDefault(node, Collections.emptyList())) {
				if (!visited[next]) {
					queue.add(next);
					visited[next] = true;
				}
			}
		}

		return max;
	}
}
