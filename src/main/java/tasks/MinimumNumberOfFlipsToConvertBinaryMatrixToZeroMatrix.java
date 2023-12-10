package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 2/16/2021
 */
@LeetCode(
		id = 1284,
		name = "Minimum Number of Flips to Convert Binary Matrix to Zero Matrix",
		url = "https://leetcode.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/",
		difficulty = Difficulty.HARD
)
public class MinimumNumberOfFlipsToConvertBinaryMatrixToZeroMatrix {
	public int minFlips(int[][] mat) {
		Queue<int[][]> queue = new LinkedList<>();
		int rows = mat.length;
		int columns = mat[0].length;
		String targetState = matToString(new int[rows][columns]);
		queue.add(mat);
		int size;
		int[][] current;
		String state;
		int[][] next;
		int steps = 0;
		Set<String> seen = new HashSet<>();
		while (!queue.isEmpty()) {
			size = queue.size();
			while (size-- > 0) {
				current = queue.remove();
				state = matToString(current);
				if (!seen.add(state)) {
					continue;
				}

				if (state.equals(targetState)) {
					return steps;
				}

				for (int row = 0; row < rows; row++) {
					for (int column = 0; column < columns; column++) {
						next = copyMat(current);

						next[row][column] = (next[row][column] + 1) % 2;

						if (row - 1 >= 0) {
							next[row - 1][column] = (next[row - 1][column] + 1) % 2;
						}

						if (row + 1 < rows) {
							next[row + 1][column] = (next[row + 1][column] + 1) % 2;
						}

						if (column - 1 >= 0) {
							next[row][column - 1] = (next[row][column - 1] + 1) % 2;
						}

						if (column + 1 < columns) {
							next[row][column + 1] = (next[row][column + 1] + 1) % 2;
						}

						queue.add(next);
					}
				}
			}

			steps++;
		}

		return -1;
	}

	private int[][] copyMat(int[][] origin) {
		int[][] copy = new int[origin.length][];
		for (int i = 0; i < origin.length; i++) {
			copy[i] = Arrays.copyOf(origin[i], origin[i].length);
		}
		return copy;
	}

	private String matToString(int[][] mat) {
		StringBuilder sb = new StringBuilder();
		for (int[] row : mat) {
			sb.append(Arrays.toString(row));
		}

		return sb.toString();
	}
}
