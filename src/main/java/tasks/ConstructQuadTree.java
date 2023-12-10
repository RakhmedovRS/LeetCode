package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/28/2020
 */
@LeetCode(
		id = 427,
		name = "Construct Quad Tree",
		url = "https://leetcode.com/problems/construct-quad-tree/",
		difficulty = Difficulty.MEDIUM
)
public class ConstructQuadTree {
	class Node {
		public boolean val;
		public boolean isLeaf;
		public Node topLeft;
		public Node topRight;
		public Node bottomLeft;
		public Node bottomRight;

		public Node() {
			this.val = false;
			this.isLeaf = false;
			this.topLeft = null;
			this.topRight = null;
			this.bottomLeft = null;
			this.bottomRight = null;
		}

		public Node(boolean val, boolean isLeaf) {
			this.val = val;
			this.isLeaf = isLeaf;
			this.topLeft = null;
			this.topRight = null;
			this.bottomLeft = null;
			this.bottomRight = null;
		}

		public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
			this.val = val;
			this.isLeaf = isLeaf;
			this.topLeft = topLeft;
			this.topRight = topRight;
			this.bottomLeft = bottomLeft;
			this.bottomRight = bottomRight;
		}
	}

	public Node construct(int[][] grid) {
		int left = 0;
		int right = grid[0].length - 1;
		int up = 0;
		int bottom = grid.length - 1;

		return constructReq(grid, left, right, up, bottom);
	}

	private Node constructReq(int[][] grid, int left, int right, int up, int bottom) {
		if (isContainedOneChar(grid, left, right, up, bottom)) {
			return new Node(grid[up][left] == 1, true);
		}

		int horizontalHalf = (left + right) / 2;
		int verticalHalf = (up + bottom) / 2;

		Node node = new Node(true, false);
		node.topLeft = constructReq(grid, left, horizontalHalf, up, verticalHalf);
		node.topRight = constructReq(grid, horizontalHalf + 1, right, up, verticalHalf);
		node.bottomLeft = constructReq(grid, left, horizontalHalf, verticalHalf + 1, bottom);
		node.bottomRight = constructReq(grid, horizontalHalf + 1, right, verticalHalf + 1, bottom);

		return node;
	}

	private boolean isContainedOneChar(int[][] grid, int left, int right, int up, int bottom) {
		int val = grid[up][left];
		for (int row = up; row <= bottom; row++) {
			for (int column = left; column <= right; column++) {
				if (grid[row][column] != val) {
					return false;
				}
			}
		}

		return true;
	}
}
