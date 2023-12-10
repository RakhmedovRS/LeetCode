package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/30/2020
 */
@LeetCode(id = 1105, name = "Filling Bookcase Shelves", url = "https://leetcode.com/problems/filling-bookcase-shelves/")
public class FillingBookcaseShelves {
	public int minHeightShelves(int[][] books, int shelf_width) {
		return dfs(0, books, shelf_width, new Integer[books.length]);
	}

	private int dfs(int pos, int[][] books, int shelf_width, Integer[] memo) {
		if (pos == books.length) {
			return 0;
		}

		if (memo[pos] != null) {
			return memo[pos];
		}

		memo[pos] = Integer.MAX_VALUE;
		int maxHeight = 0;
		int currentShelf = 0;
		for (int i = pos; i < books.length && currentShelf + books[i][0] <= shelf_width; i++) {
			currentShelf += books[i][0];
			maxHeight = Math.max(maxHeight, books[i][1]);
			memo[pos] = Math.min(memo[pos], maxHeight + dfs(i + 1, books, shelf_width, memo));
		}

		return memo[pos];
	}
}
