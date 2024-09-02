package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-09-01
 */
@LeetCode(
		id = 3275,
		name = "K-th Nearest Obstacle Queries",
		url = "https://leetcode.com/problems/k-th-nearest-obstacle-queries/description/",
		difficulty = Difficulty.MEDIUM
)
public class KthNearestObstacleQueries {
	public int[] resultsArray(int[][] queries, int k) {
		int pos = 0;
		int[] ans = new int[queries.length];
		Arrays.fill(ans, -1);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for (int[] q : queries) {
			pq.add(Math.abs(q[0]) + Math.abs(q[1]));
			while (pq.size() > k) {
				pq.remove();
			}

			if (pq.size() == k) {
				ans[pos] = pq.peek();
			}
			pos++;
		}
		return ans;
	}
}