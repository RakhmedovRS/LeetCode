package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 4/19/2023
 */
@LeetCode(
		id = 2642,
		name = "Design Graph With Shortest Path Calculator",
		url = "https://leetcode.com/problems/design-graph-with-shortest-path-calculator/",
		difficulty = Difficulty.HARD
)
public class DesignGraphWithShortestPathCalculator {
	class Graph {
		Map<Integer, Map<Integer, Integer>> cost;
		int n;

		public Graph(int n, int[][] edges) {
			cost = new HashMap<>();
			for (int[] edge : edges) {
				cost.putIfAbsent(edge[0], new HashMap<>());
				cost.get(edge[0]).put(edge[1], edge[2]);
			}
			this.n = n;
		}

		public void addEdge(int[] edge) {
			cost.putIfAbsent(edge[0], new HashMap<>());
			cost.get(edge[0]).put(edge[1], edge[2]);
		}

		public int shortestPath(int node1, int node2) {
			int[] distance = new int[n];
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[node1] = 0;

			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
			pq.add(new int[]{node1, 0});

			Set<Integer> set = new HashSet<>();
			while (set.size() < n) {
				if (pq.isEmpty()) {
					break;
				}

				int[] min = pq.remove();
				if (set.contains(min[0])) {
					continue;
				}

				set.add(min[0]);
				relatives(min, pq, set, distance);
			}

			return distance[node2] == Integer.MAX_VALUE ? -1 : distance[node2];
		}

		private void relatives(int[] min, PriorityQueue<int[]> pq, Set<Integer> set, int[] distance) {
			for (Map.Entry<Integer, Integer> entry : cost.getOrDefault(min[0], Collections.emptyMap()).entrySet()) {
				int node = entry.getKey();
				int cost = entry.getValue();

				if (!set.contains(node)) {
					int newCost = cost + min[1];
					if (newCost < distance[node]) {
						distance[node] = newCost;
					}

					pq.add(new int[]{node, distance[node]});
				}
			}
		}
	}
}
