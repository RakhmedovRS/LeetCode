package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-08-03
 */
@LeetCode(
		id = 3242,
		name = "Design Neighbor Sum Service",
		url = "https://leetcode.com/problems/design-neighbor-sum-service/description/",
		difficulty = Difficulty.EASY
)
public class DesignNeighborSumService {
	class neighborSum {
		int[][] grid;
		Map<Integer, List<int[]>> positions = new HashMap<>();

		public neighborSum(int[][] grid) {
			this.grid = grid;
			for (int row = 0; row < grid.length; row++) {
				for (int column = 0; column < grid[row].length; column++) {
					positions.computeIfAbsent(grid[row][column], r -> new ArrayList<>()).add(new int[]{row, column});
				}
			}
		}


		public int adjacentSum(int value) {
			int sum = 0;
			for (int[] pos : positions.getOrDefault(value, Collections.emptyList())) {
				int r = pos[0];
				int c = pos[1];
				if (r - 1 >= 0) {
					sum += grid[r - 1][c];
				}

				if (r + 1 < grid.length) {
					sum += grid[r + 1][c];
				}

				if (c - 1 >= 0) {
					sum += grid[r][c - 1];
				}

				if (c + 1 < grid[0].length) {
					sum += grid[r][c + 1];
				}
			}
			return sum;
		}

		public int diagonalSum(int value) {
			int sum = 0;
			for (int[] pos : positions.getOrDefault(value, Collections.emptyList())) {
				int r = pos[0];
				int c = pos[1];
				if (r - 1 >= 0 && c - 1 >= 0) {
					sum += grid[r - 1][c - 1];
				}

				if (r - 1 >= 0 && c + 1 < grid[0].length) {
					sum += grid[r - 1][c + 1];
				}

				if (r + 1 < grid.length && c + 1 < grid[0].length) {
					sum += grid[r + 1][c + 1];
				}

				if (r + 1 < grid.length && c - 1 >= 0) {
					sum += grid[r + 1][c - 1];
				}
			}
			return sum;
		}
	}
}