package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-10-05
 */
@LeetCode(
		id = 3310,
		name = "Remove Methods From Project",
		url = "https://leetcode.com/problems/remove-methods-from-project/description/",
		difficulty = Difficulty.MEDIUM
)
public class RemoveMethodsFromProject {
	public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
		Set<Integer> normalNodes = new HashSet<>();
		for (int i = 0; i < n; i++) {
			normalNodes.add(i);
		}

		Map<Integer, Set<Integer>> graph = new HashMap<>();
		for (int[] i : invocations) {
			int a = i[0];
			int b = i[1];
			graph.computeIfAbsent(a, A -> new HashSet<>()).add(b);
		}

		Set<Integer> suspiciousNodes = new HashSet<>();
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(k);
		while (!queue.isEmpty()) {
			int curr = queue.removeLast();
			if (!suspiciousNodes.add(curr)) {
				continue;
			}

			queue.addAll(graph.getOrDefault(curr, Collections.emptySet()));
		}

		for (int[] i : invocations) {
			int a = i[0];
			int b = i[1];

			if (!suspiciousNodes.contains(a) && suspiciousNodes.contains(b)) {
				return new ArrayList<>(normalNodes);
			}
		}

		normalNodes.removeAll(suspiciousNodes);
		return new ArrayList<>(normalNodes);
	}
}