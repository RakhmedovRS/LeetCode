package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10-Aug-20
 */
@LeetCode(id = 892, name = "Surface Area of 3D Shapes", url = "https://leetcode.com/problems/surface-area-of-3d-shapes/")
public class SurfaceAreaOf3DShapes {
	public int surfaceArea(int[][] grid) {
		int surface = 0;
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++) {
				if (grid[row][column] > 0) {
					surface += 2 + around(grid, row, column);
				}
			}
		}

		return surface;
	}

	private int around(int[][] grid, int row, int column) {
		return Math.max(grid[row][column] - (row > 0 ? grid[row - 1][column] : 0), 0)
				+ Math.max(grid[row][column] - (row < grid.length - 1 ? grid[row + 1][column] : 0), 0)
				+ Math.max(grid[row][column] - (column > 0 ? grid[row][column - 1] : 0), 0)
				+ Math.max(grid[row][column] - (column < grid[row].length - 1 ? grid[row][column + 1] : 0), 0);
	}
}
