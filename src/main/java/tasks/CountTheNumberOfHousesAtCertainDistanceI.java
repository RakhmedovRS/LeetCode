package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-01-20
 */
@LeetCode(
		id = 3015,
		name = "Count the Number of Houses at a Certain Distance I",
		url = "https://leetcode.com/problems/count-the-number-of-houses-at-a-certain-distance-i/description/",
		difficulty = Difficulty.MEDIUM
)
public class CountTheNumberOfHousesAtCertainDistanceI {
	public int[] countOfPairs(int n, int x, int y) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 2; i <= n; i++) {
			List<Integer> prev = graph.getOrDefault(i - 1, new ArrayList<>());
			prev.add(i);
			graph.put(i - 1, prev);

			List<Integer> curr = graph.getOrDefault(i, new ArrayList<>());
			curr.add(i - 1);
			graph.put(i, curr);
		}

		if (x != y) {
			List<Integer> X = graph.getOrDefault(x, new ArrayList<>());
			X.add(y);
			graph.put(x, X);

			List<Integer> Y = graph.getOrDefault(y, new ArrayList<>());
			Y.add(x);
			graph.put(y, Y);
		}

		int[] pairs = new int[n];
		Integer[][] memo = new Integer[n + 1][n + 1];
		for (int start = 1; start <= n; start++) {
			for (int target = 1; target <= n; target++) {
				if (start == target) {
					continue;
				}

				int distance = getMinDistance(start, target, graph, memo);
				if (distance != -1) {
					pairs[distance - 1]++;
				}
			}
		}

		return pairs;
	}

	private int getMinDistance(int start, int target, Map<Integer, List<Integer>> graph, Integer[][] memo) {
		if (memo[start][target] != null) {
			return memo[start][target];
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq.add(new int[]{start, 0});

		boolean[] visited = new boolean[graph.size() + 1];
		while (!pq.isEmpty()) {
			int[] curr = pq.remove();
			int pos = curr[0];
			int steps = curr[1];

			if (pos == target) {
				memo[start][target] = steps;
				memo[target][start] = steps;
				return steps;
			}

			if (visited[pos]) {
				continue;
			}

			visited[pos] = true;


			for (int next : graph.getOrDefault(pos, Collections.emptyList())) {
				pq.add(new int[]{next, steps + 1});
			}
		}

		return -1;
	}
}