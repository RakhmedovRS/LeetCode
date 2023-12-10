package tasks;

import common.LeetCode;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 20-Jun-20
 */
@LeetCode(id = 519, name = "Random Flip Matrix", url = "https://leetcode.com/problems/random-flip-matrix/")
public class RandomFlipMatrix {
	class Solution {
		int rows;
		int columns;
		Random random;
		Set<String> set;

		public Solution(int n_rows, int n_cols) {
			set = new HashSet<>();
			rows = n_rows;
			columns = n_cols;
			random = new Random();
		}

		public int[] flip() {
			int row = random.nextInt(rows);
			int column = random.nextInt(columns);
			while (!set.add(row + "_" + column)) {
				row = random.nextInt(rows);
				column = random.nextInt(columns);
			}

			return new int[]{row, column};
		}

		public void reset() {
			set.clear();
		}
	}
}
