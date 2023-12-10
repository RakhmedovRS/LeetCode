package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/10/2020
 */
@LeetCode(
		id = 1391,
		name = "Check if There is a Valid Path in a Grid",
		url = "https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/",
		difficulty = Difficulty.MEDIUM
)
public class CheckIfThereIsValidPathInGrid {
	enum Direction {
		UP(-1, 0),
		DOWN(1, 0),
		LEFT(0, -1),
		RIGHT(0, 1);

		int x;
		int y;

		Direction(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public Direction getSource(Direction direction) {
			if (direction == DOWN) {
				return UP;
			}
			else if (direction == UP) {
				return DOWN;
			}
			else if (direction == LEFT) {
				return RIGHT;
			}
			else {
				return LEFT;
			}
		}
	}

	class Route {
		Direction enter;
		Direction exit;

		public Route(Direction enter, Direction exit) {
			this.enter = enter;
			this.exit = exit;
		}
	}

	public boolean hasValidPath(int[][] grid) {
		if (grid[0][0] == 5) {
			return false;
		}

		int rows = grid.length;
		int columns = grid[0].length;

		if (rows == 1 && columns == 1) {
			return true;
		}

		Route[] routes = new Route[]{null,
				new Route(Direction.LEFT, Direction.RIGHT),
				new Route(Direction.UP, Direction.DOWN),
				new Route(Direction.LEFT, Direction.DOWN),
				new Route(Direction.DOWN, Direction.RIGHT),
				new Route(Direction.LEFT, Direction.UP),
				new Route(Direction.UP, Direction.RIGHT),
		};

		return dfs(routes[grid[0][0]].enter.x, routes[grid[0][0]].enter.y, rows, columns, grid, routes[grid[0][0]].enter, routes, new boolean[rows][columns])
				|| dfs(routes[grid[0][0]].exit.x, routes[grid[0][0]].exit.y, rows, columns, grid, routes[grid[0][0]].exit, routes, new boolean[rows][columns]);
	}

	private boolean dfs(int row, int column, int rows, int columns, int[][] grid, Direction direction, Route[] routes, boolean[][] visited) {
		if (row < 0 || row == rows || column < 0 || column == columns || visited[row][column]) {
			return false;
		}

		visited[row][column] = true;

		if (direction.getSource(direction) != routes[grid[row][column]].enter && direction.getSource(direction) != routes[grid[row][column]].exit) {
			return false;
		}

		if (row == rows - 1 && column == columns - 1) {
			return true;
		}

		return dfs(row + routes[grid[row][column]].exit.x, column + routes[grid[row][column]].exit.y, rows, columns, grid, routes[grid[row][column]].exit, routes, visited)
				|| dfs(row + routes[grid[row][column]].enter.x, column + routes[grid[row][column]].enter.y, rows, columns, grid, routes[grid[row][column]].enter, routes, visited);
	}

	public static void main(String[] args) {
		System.out.println(new CheckIfThereIsValidPathInGrid().hasValidPath(new int[][]
				{
						{3, 4, 3, 4},
						{2, 2, 2, 2},
						{6, 5, 6, 5},
				}));

		System.out.println(new CheckIfThereIsValidPathInGrid().hasValidPath(new int[][]
				{
						{1, 2, 1},
						{1, 2, 1}
				}));

		System.out.println(new CheckIfThereIsValidPathInGrid().hasValidPath(new int[][]
				{
						{6, 1, 3},
						{4, 1, 5}
				}));

		System.out.println(new CheckIfThereIsValidPathInGrid().hasValidPath(new int[][]
				{
						{1, 1},
				}));

		System.out.println(new CheckIfThereIsValidPathInGrid().hasValidPath(new int[][]
				{
						{2},
						{2},
				}));

		System.out.println(new CheckIfThereIsValidPathInGrid().hasValidPath(new int[][]
				{
						{2, 4, 3},
						{6, 5, 2}
				}));

		System.out.println(new CheckIfThereIsValidPathInGrid().hasValidPath(new int[][]
				{
						{4, 1},
						{6, 1}
				}));
	}
}
