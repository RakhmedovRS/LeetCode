package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 1/21/2021
 */
@LeetCode(
		id = 1730,
		name = "Shortest Path to Get Food",
		url = "https://leetcode.com/problems/shortest-path-to-get-food/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class ShortestPathToGetFood {
	public int getFood(char[][] grid) {
		int rows = grid.length;
		if (rows == 0) {
			return -1;
		}
		int columns = grid[0].length;

		int[][] steps = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		boolean[][] visited = new boolean[rows][columns];
		Queue<int[]> queue = new LinkedList<>();
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				if (grid[row][column] == '*') {
					queue.add(new int[]{row, column});
					break;
				}
			}
		}

		int[] current;
		int size;
		int way = 0;
		int row;
		int column;
		int nextRow;
		int nextColumn;
		while (!queue.isEmpty()) {
			size = queue.size();
			while (size-- > 0) {
				current = queue.remove();
				row = current[0];
				column = current[1];
				if (visited[row][column]) {
					continue;
				}

				visited[row][column] = true;
				if (grid[row][column] == '#') {
					return way;
				}

				for (int[] step : steps) {
					nextRow = row + step[0];
					nextColumn = column + step[1];
					if (nextRow < 0 || nextRow == rows || nextColumn < 0 || nextColumn == columns || grid[nextRow][nextColumn] == 'X' || visited[nextRow][nextColumn]) {
						continue;
					}
					queue.add(new int[]{nextRow, nextColumn});
				}
			}
			way++;
		}

		return -1;
	}
}
