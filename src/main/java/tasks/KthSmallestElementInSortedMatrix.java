package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 28-Apr-20
 */
@LeetCode(
		id = 378,
		name = "Kth Smallest Element in a Sorted Matrix",
		url = "https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/",
		difficulty = Difficulty.MEDIUM
)
public class KthSmallestElementInSortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> matrix[a[0]][a[1]]));
		for (int row = 0; row < matrix.length; row++) {
			pq.add(new int[]{row, 0});
		}

		while (k-- > 0) {
			int[] current = pq.remove();
			int row = current[0];
			int column = current[1];
			int val = matrix[row][column];

			if (k == 0) {
				return val;
			}

			column++;
			if (column < matrix[row].length) {
				pq.add(new int[]{row, column});
			}
		}

		return 0;
	}
}
