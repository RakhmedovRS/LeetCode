package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-04-13
 */
@LeetCode(
		id = 3112,
		name = "Minimum Time to Visit Disappearing Nodes",
		url = "https://leetcode.com/problems/minimum-time-to-visit-disappearing-nodes/description/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumTimeToVisitDisappearingNodes {
	public int[] minimumTime(int n, int[][] edges, int[] disappear) {
		Map<Integer, List<int[]>> graph = buildUndirectedGraph(edges);
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq.add(new int[]{0, 0});
		int[] answer = new int[n];
		Arrays.fill(answer, -1);
		while (!pq.isEmpty()) {
			int[] current = pq.remove();
			int vertex = current[0];
			int time = current[1];
			if (disappear[vertex] <= time) {
				continue;
			}

			if (answer[vertex] == -1) {
				answer[vertex] = time;
			} else if (answer[vertex] <= time) {
				continue;
			}

			for (int[] neighbor : graph.getOrDefault(vertex, Collections.emptyList())) {
				pq.add(new int[]{neighbor[0], neighbor[1] + time});
			}
		}

		return answer;
	}

	public Map<Integer, List<int[]>> buildUndirectedGraph(int[][] edges) {
		Map<Integer, List<int[]>> graph = new HashMap<>();
		for (int[] edge : edges) {
			graph.putIfAbsent(edge[0], new ArrayList<>());
			graph.putIfAbsent(edge[1], new ArrayList<>());

			graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
			graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
		}

		return graph;
	}
}