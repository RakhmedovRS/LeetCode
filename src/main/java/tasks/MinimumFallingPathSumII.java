package tasks;

import common.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 17-Jun-20
 */
@LeetCode(id = 1289, name = "Minimum Falling Path Sum II", url = "https://leetcode.com/problems/minimum-falling-path-sum-ii/")
public class MinimumFallingPathSumII {
	public int minFallingPathSum(int[][] arr) {
		int rows = arr.length;
		int columns = arr[0].length;

		Comparator<int[]> comparator = (arr1, arr2) ->
		{
			if (arr1[0] == arr2[0]) {
				return arr1[1] - arr2[1];
			}
			return arr1[0] - arr2[0];
		};

		PriorityQueue<int[]> prevPQ = new PriorityQueue<>(comparator);
		for (int column = 0; column < columns; column++) {
			prevPQ.add(new int[]{arr[0][column], column});
		}

		for (int row = 1; row < rows; row++) {
			PriorityQueue<int[]> currentRowPQ = new PriorityQueue<>(comparator);
			for (int column = 0; column < columns; column++) {
				int[] min;
				if (prevPQ.peek()[1] == column) {
					int[] temp = prevPQ.remove();
					min = new int[]{arr[row][column] += prevPQ.peek()[0], column};
					prevPQ.add(temp);
				}
				else {
					min = new int[]{arr[row][column] += prevPQ.peek()[0], column};
				}
				currentRowPQ.add(min);
			}

			prevPQ = currentRowPQ;
		}

		return prevPQ.peek()[0];
	}
}
