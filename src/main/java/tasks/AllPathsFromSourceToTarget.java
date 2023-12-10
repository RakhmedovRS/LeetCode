package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 11-Jun-20
 */
@LeetCode(
		id = 797,
		name = "All Paths From Source to Target",
		url = "https://leetcode.com/problems/all-paths-from-source-to-target/",
		difficulty = Difficulty.MEDIUM
)
public class AllPathsFromSourceToTarget {
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> currentPath = new ArrayList<>();
		currentPath.add(0);
		dfs(graph, 0, currentPath, result);

		return result;
	}

	private void dfs(int[][] graph, int currentNode,
					 List<Integer> currentPath, List<List<Integer>> result) {
		if (currentNode == graph.length - 1) {
			result.add(new ArrayList<>(currentPath));
			return;
		}

		for (int node : graph[currentNode]) {
			currentPath.add(node);
			dfs(graph, node, currentPath, result);
			currentPath.remove(currentPath.size() - 1);
		}
	}
}
