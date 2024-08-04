package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-08-03
 */
@LeetCode(
		id = 3243,
		name = "Shortest Distance After Road Addition Queries I",
		url = "https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i/description/",
		difficulty = Difficulty.MEDIUM
)
public class ShortestDistanceAfterRoadAdditionQueriesI {
	public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
		int[] dist = new int[n];
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 1; i < n; i++) {
			dist[i] = i;
			graph.computeIfAbsent(i - 1, a -> new ArrayList<>()).add(i);
		}

		int[] ans = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int[] query = queries[i];
			graph.get(query[0]).add(query[1]);
			LinkedList<int[]> queue = new LinkedList<>();
			for (int nextCity : graph.get(query[0])) {
				queue.addLast(new int[]{nextCity, dist[query[0]] + 1});
			}
			while (!queue.isEmpty()) {
				int[] curr = queue.removeFirst();
				int city = curr[0];
				int newDist = curr[1];
				if (dist[city] <= newDist) {
					continue;
				}

				dist[city] = newDist;

				for (int nextCity : graph.getOrDefault(city, Collections.emptyList())) {
					queue.addLast(new int[]{nextCity, newDist + 1});
				}
			}

			ans[i] = dist[n - 1];
		}

		return ans;
	}
}