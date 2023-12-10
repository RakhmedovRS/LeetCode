package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 6/27/2021
 */
@LeetCode(
		id = 1914,
		name = "Cyclically Rotating a Grid",
		url = "https://leetcode.com/problems/cyclically-rotating-a-grid/",
		difficulty = Difficulty.MEDIUM
)
public class CyclicallyRotatingGrid {
	public int[][] rotateGrid(int[][] grid, int k) {
		LinkedList<LinkedList<Integer>> list = new LinkedList<>();

		int left = 0;
		int right = grid[0].length - 1;
		int up = 0;
		int down = grid.length - 1;

		while (left <= right && up <= down) {
			LinkedList<Integer> current = new LinkedList<>();
			for (int c = left; c <= right; c++) {
				current.addLast(grid[up][c]);
			}
			up++;

			for (int r = up; r <= down; r++) {
				current.addLast(grid[r][right]);
			}
			right--;

			for (int c = right; c >= left; c--) {
				current.addLast(grid[down][c]);
			}
			down--;

			for (int r = down; r >= up; r--) {
				current.addLast(grid[r][left]);
			}
			left++;

			list.add(current);
		}

		for (LinkedList<Integer> l : list) {
			int r = k % l.size();
			while (r-- > 0) {
				l.addLast(l.removeFirst());
			}
		}

		left = 0;
		right = grid[0].length - 1;
		up = 0;
		down = grid.length - 1;

		while (left <= right && up <= down) {
			LinkedList<Integer> current = list.removeFirst();
			for (int c = left; c <= right; c++) {
				grid[up][c] = current.removeFirst();
			}
			up++;

			for (int r = up; r <= down; r++) {
				grid[r][right] = current.removeFirst();
			}
			right--;

			for (int c = right; c >= left; c--) {
				grid[down][c] = current.removeFirst();
			}
			down--;

			for (int r = down; r >= up; r--) {
				grid[r][left] = current.removeFirst();
			}
			left++;
		}

		return grid;
	}
}
