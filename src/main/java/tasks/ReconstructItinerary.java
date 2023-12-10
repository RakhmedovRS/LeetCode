package tasks;

import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 28-Jun-20
 */
@LeetCode(id = 332, name = "Reconstruct Itinerary", url = "https://leetcode.com/problems/reconstruct-itinerary/")
public class ReconstructItinerary {
	public List<String> findItinerary(List<List<String>> tickets) {
		LinkedList<String> answer = new LinkedList<>();
		Map<String, PriorityQueue<String>> graph = new HashMap<>();
		for (List<String> ticket : tickets) {
			String from = ticket.get(0);
			String to = ticket.get(1);
			PriorityQueue<String> targets = graph.getOrDefault(from, new PriorityQueue<>());
			targets.add(to);
			graph.put(from, targets);
		}

		findRoute(graph, "JFK", answer);

		return answer.size() == 1 ? new ArrayList<>() : answer;
	}

	private void findRoute(Map<String, PriorityQueue<String>> graph, String from, LinkedList<String> answer) {
		PriorityQueue<String> to = graph.getOrDefault(from, new PriorityQueue<>());
		while (!to.isEmpty()) {
			String target = to.remove();
			findRoute(graph, target, answer);
		}

		answer.addFirst(from);
	}
}
