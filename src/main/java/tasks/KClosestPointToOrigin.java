package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 30-May-20
 */
@LeetCode(
		id = 973,
		name = "K Closest Points to Origin",
		url = "https://leetcode.com/problems/k-closest-points-to-origin/",
		difficulty = Difficulty.MEDIUM
)
public class KClosestPointToOrigin {
	public int[][] kClosest(int[][] points, int K) {
		int[][] answer = new int[K][];
		int[] pows = new int[points.length];
		for (int i = 0; i < points.length; i++) {
			pows[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
		}

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i = 0; i < points.length; i++) {
			minHeap.add(i);
		}

		int i = 0;
		while (i < K) {
			answer[i++] = points[minHeap.remove()];
		}

		return answer;
	}
}
