package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 12/4/2020
 */
@LeetCode(
		id = 1086,
		name = "High Five",
		url = "https://leetcode.com/problems/high-five/",
		difficulty = Difficulty.EASY,
		premium = true
)
public class HighFive {
	public int[][] highFive(int[][] items) {
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
		Set<Integer> ids = new HashSet<>();
		int id;
		int score;
		for (int[] item : items) {
			id = item[0];
			score = item[1];
			ids.add(id);
			map.putIfAbsent(id, new PriorityQueue<>());

			PriorityQueue<Integer> pq = map.get(id);
			if (pq.size() == 5 && pq.peek() < score) {
				pq.remove();
				pq.add(score);
			}
			else if (pq.size() < 5) {
				pq.add(score);
			}
		}

		List<Integer> sortedIds = new ArrayList<>(ids);
		sortedIds.sort(null);

		int[][] answer = new int[ids.size()][];
		for (int i = 0; i < sortedIds.size(); i++) {
			id = sortedIds.get(i);
			int sum = 0;
			PriorityQueue<Integer> pq = map.get(id);
			for (Integer s : pq) {
				sum += s;
			}

			answer[i] = new int[]{id, sum / (pq.isEmpty() ? 1 : pq.size())};
		}

		return answer;
	}
}
