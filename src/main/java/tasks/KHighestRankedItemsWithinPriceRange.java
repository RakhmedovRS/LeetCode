package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 1/22/2022
 */
@LeetCode(
		id = 2146,
		name = "K Highest Ranked Items Within a Price Range",
		url = "https://leetcode.com/problems/k-highest-ranked-items-within-a-price-range/",
		difficulty = Difficulty.MEDIUM
)
public class KHighestRankedItemsWithinPriceRange {
	public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
		List<List<Integer>> answer = new ArrayList<>();
		int rows = grid.length;
		int columns = grid[0].length;
		boolean[][] visited = new boolean[rows][columns];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{start[0], start[1], 0});
		int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		List<List<Integer>> list = new ArrayList<>();
		while (!queue.isEmpty()) {
			int[] current = queue.remove();
			int row = current[0];
			int column = current[1];
			if (visited[row][column] || grid[row][column] == 0) {
				continue;
			}

			visited[row][column] = true;
			if (grid[row][column] >= pricing[0] && (grid[row][column] <= pricing[1])) {
				list.add(Arrays.asList(row, column, current[2], grid[row][column]));
			}

			for (int[] dir : directions) {
				int nextR = row + dir[0];
				int nextC = column + dir[1];
				if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < columns) {
					queue.add(new int[]{nextR, nextC, current[2] + 1});
				}
			}
		}

		list.sort((a, b) ->
		{
			if (a.get(2).equals(b.get(2))) {
				if (a.get(3).equals(b.get(3))) {
					if (a.get(0).equals(b.get(0))) {
						return a.get(1) - b.get(1);
					}
					return a.get(0) - b.get(0);
				}
				return a.get(3) - b.get(3);
			}
			return a.get(2) - b.get(2);
		});

		int pos = 0;
		while (k-- > 0) {
			if (pos < list.size()) {
				answer.add(Arrays.asList(list.get(pos).get(0), list.get(pos).get(1)));
				pos++;
			}
		}

		return answer;
	}
}
