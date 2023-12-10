package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 29-Jun-20
 */
@LeetCode(id = 802, name = "Find Eventual Safe States", url = "https://leetcode.com/problems/find-eventual-safe-states/")
public class FindEventualSafeStates {
	public List<Integer> eventualSafeNodes(int[][] graph) {
		int[] colour = new int[graph.length];

		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i < graph.length; i++) {
			if (traverse(graph, i, colour)) {
				answer.add(i);
			}
		}

		return answer;
	}

	private boolean traverse(int[][] graph, int position, int[] colour) {
		if (colour[position] > 0) {
			return colour[position] == 2;
		}

		colour[position] = 1;
		for (int nextPosition : graph[position]) {
			if (colour[nextPosition] == 2) {
				continue;
			}

			if (colour[nextPosition] == 1 || !traverse(graph, nextPosition, colour)) {
				return false;
			}
		}

		colour[position] = 2;
		return true;
	}
}
