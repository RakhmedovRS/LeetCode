package tasks;

import common.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 27-Jul-20
 */
@LeetCode(id = 934, name = "Shortest Bridge", url = "https://leetcode.com/problems/shortest-bridge/")
public class ShortestBridge {
	public int shortestBridge(int[][] A) {
		int rows = A.length;
		int columns = A[0].length;
		boolean[][] visited = new boolean[rows][columns];

		Queue<int[]> queue = new LinkedList<>();
		outer:
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				if (A[row][column] == 1) {
					eraseIsland(A, row, column, rows, columns, visited, queue);
					break outer;
				}
			}
		}

		int steps = 0;
		int levelSize;
		int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		while (!queue.isEmpty()) {
			levelSize = queue.size();
			while (levelSize-- > 0) {
				int[] point = queue.remove();
				for (int[] direction : directions) {
					int nextRow = point[0] + direction[0];
					int nextColumn = point[1] + direction[1];
					if (nextRow < 0
							|| nextRow == rows
							|| nextColumn < 0
							|| nextColumn == columns) {
						continue;
					}

					if (A[nextRow][nextColumn] == 1) {
						return steps;
					}

					if (!visited[nextRow][nextColumn]) {
						visited[nextRow][nextColumn] = true;
						queue.add(new int[]{nextRow, nextColumn});
					}
				}
			}
			steps++;
		}

		return steps;
	}

	private void eraseIsland(int[][] A, int row, int column, int rows, int columns, boolean[][] visited, Queue<int[]> queue) {
		if (row < 0
				|| row == rows
				|| column < 0
				|| column == columns
				|| A[row][column] == 0
				|| visited[row][column]) {
			return;
		}

		visited[row][column] = true;
		A[row][column] = 0;
		queue.add(new int[]{row, column});
		eraseIsland(A, row - 1, column, rows, columns, visited, queue);
		eraseIsland(A, row + 1, column, rows, columns, visited, queue);
		eraseIsland(A, row, column - 1, rows, columns, visited, queue);
		eraseIsland(A, row, column + 1, rows, columns, visited, queue);
	}
}
