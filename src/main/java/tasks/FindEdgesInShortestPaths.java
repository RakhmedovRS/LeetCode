package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-04-20
 */
@LeetCode(
		id = 3123,
		name = "Find Edges in Shortest Paths",
		url = "https://leetcode.com/problems/find-edges-in-shortest-paths/description/",
		difficulty = Difficulty.HARD
)
public class FindEdgesInShortestPaths {
	public boolean[] findAnswer(int n, int[][] edges) {
		Map<Integer, List<int[]>> graph = new HashMap<>();
		for (int i = 0; i < edges.length; i++) {
			int[] edge = edges[i];
			int a = edge[0];
			int b = edge[1];
			int w = edge[2];

			List<int[]> listA = graph.computeIfAbsent(a, aa -> new ArrayList<>());
			listA.add(new int[]{b, w, i});

			List<int[]> listB = graph.computeIfAbsent(b, bb -> new ArrayList<>());
			listB.add(new int[]{a, w, i});
		}
		boolean[] answer = new boolean[edges.length];
		findShortestPath(n, 0, n - 1, graph, answer);

		return answer;
	}

	private void findShortestPath(int n, int pointA, int pointB, Map<Integer, List<int[]>> graph, boolean[] answer) {
		Map<Integer, List<Integer>> prevs = new HashMap<>();
		long[] weights = new long[n];
		Arrays.fill(weights, Long.MAX_VALUE);
		weights[0] = 0;
		PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
		for (int[] neighborInfo : graph.getOrDefault(pointA, Collections.emptyList())) {
			int nextPoint = neighborInfo[0];
			int weight = neighborInfo[1];
			int edgeIndex = neighborInfo[2];

			pq.add(new long[]{weight, nextPoint, edgeIndex, -1});
		}

		while (!pq.isEmpty()) {
			long[] current = pq.remove();
			long weight = current[0];
			int currentPoint = (int) current[1];
			int edgeIndex = (int) current[2];
			int prevIndex = (int) current[3];

			if (weight > weights[currentPoint]) {
				continue;
			}

			weights[currentPoint] = weight;
			List<Integer> list = prevs.computeIfAbsent(edgeIndex, p -> new ArrayList<>());
			list.add(prevIndex);

			if (currentPoint == pointB) {
				LinkedList<Integer> ll = new LinkedList<>();
				ll.add(edgeIndex);
				while (!ll.isEmpty()) {
					int index = ll.removeFirst();
					if (index == -1) {
						continue;
					}
					answer[index] = true;
					ll.addAll(prevs.get(index));
				}
				continue;
			}

			for (int[] neighborInfo : graph.getOrDefault(currentPoint, Collections.emptyList())) {
				int nextPoint = neighborInfo[0];
				long w = neighborInfo[1];
				int nextEdgeIndex = neighborInfo[2];

				pq.add(new long[]{w + weight, nextPoint, nextEdgeIndex, edgeIndex});
			}
		}
	}
}