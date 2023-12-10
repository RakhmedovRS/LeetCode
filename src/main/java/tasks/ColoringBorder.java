package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 18-Sep-20
 */
@LeetCode(
		id = 1034,
		name = "Coloring A Border",
		url = "https://leetcode.com/problems/coloring-a-border/",
		difficulty = Difficulty.MEDIUM
)
public class ColoringBorder {
	public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
		int rows = grid.length;
		int columns = grid[0].length;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{r0, c0});
		int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
		boolean[][] visited = new boolean[rows][columns];
		int size;
		List<int[]> recolor = new ArrayList<>();
		while (!queue.isEmpty()) {
			size = queue.size();
			while (size-- > 0) {
				int[] pos = queue.remove();
				int x = pos[0];
				int y = pos[1];
				if (visited[x][y]) {
					continue;
				}

				visited[x][y] = true;

				int nextX;
				int nextY;
				for (int[] direction : directions) {
					nextX = x + direction[0];
					nextY = y + direction[1];
					if (nextX < 0 || nextX == rows || nextY < 0 || nextY == columns || visited[nextX][nextY] || grid[x][y] != grid[nextX][nextY]) {
						continue;
					}

					queue.add(new int[]{nextX, nextY});
				}

				if (x == 0 || x == rows - 1 || y == 0 || y == columns - 1) {
					recolor.add(pos);
				}
				else {
					for (int[] direction : directions) {
						nextX = x + direction[0];
						nextY = y + direction[1];
						if (nextX < 0 || nextX == rows || nextY < 0 || nextY == columns || grid[x][y] != grid[nextX][nextY]) {
							recolor.add(pos);
							break;
						}
					}
				}
			}
		}

		for (int[] position : recolor) {
			grid[position[0]][position[1]] = color;
		}

		return grid;
	}
}
