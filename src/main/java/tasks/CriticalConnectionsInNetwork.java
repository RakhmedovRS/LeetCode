package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 4/24/2021
 */
@LeetCode(
		id = 1192,
		name = "Critical Connections in a Network",
		url = "https://leetcode.com/problems/critical-connections-in-a-network/",
		difficulty = Difficulty.HARD
)
public class CriticalConnectionsInNetwork {
	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> edges) {
		List<List<Integer>> answer = new ArrayList<>();
		Integer[] ids = new Integer[n];
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (List<Integer> edge : edges) {
			graph.putIfAbsent(edge.get(0), new ArrayList<>());
			graph.putIfAbsent(edge.get(1), new ArrayList<>());

			graph.get(edge.get(0)).add(edge.get(1));
			graph.get(edge.get(1)).add(edge.get(0));
		}

		dfs(-1, 0, new int[]{0}, ids, graph, new Integer[n], answer, new boolean[n]);

		return answer;
	}

	private void dfs(int parent, int vertex, int[] id, Integer[] ids, Map<Integer, List<Integer>> graph, Integer[] lows, List<List<Integer>> answer, boolean[] visited) {
		visited[vertex] = true;
		ids[vertex] = id[0];
		lows[vertex] = id[0]++;

		for (int nextVertex : graph.getOrDefault(vertex, Collections.emptyList())) {
			if (nextVertex == parent) {
				continue;
			}

			if (!visited[nextVertex]) {
				dfs(vertex, nextVertex, id, ids, graph, lows, answer, visited);
			}

			lows[vertex] = Math.min(lows[vertex], lows[nextVertex]);

			if (ids[vertex] < lows[nextVertex]) {
				answer.add(Arrays.asList(vertex, nextVertex));
			}
		}
	}
}
