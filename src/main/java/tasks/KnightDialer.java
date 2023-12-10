package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 01-Jul-20
 */
@LeetCode(
		id = 935,
		name = "Knight Dialer",
		url = "https://leetcode.com/problems/knight-dialer/",
		difficulty = Difficulty.MEDIUM
)
public class KnightDialer {
	int MOD = 1_000_000_007;

	public int knightDialer(int n) {
		int[][] grid = new int[][]{
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9},
				{5, 0, 5},
		};

		int[][] memo = new int[][]{
				{1, 1, 1},
				{1, 1, 1},
				{1, 1, 1},
				{0, 1, 0},
		};

		Map<Integer, List<int[]>> moves = new HashMap<>();
		// 1 -> 6, 1 -> 8
		moves.put(1, Arrays.asList(new int[]{1, 2}, new int[]{2, 1}));
		// 2 -> 7, 2 -> 9
		moves.put(2, Arrays.asList(new int[]{2, 0}, new int[]{2, 2}));
		// 3 -> 4, 3 -> 8
		moves.put(3, Arrays.asList(new int[]{1, 0}, new int[]{2, 1}));
		// 4 -> 3, 4 -> 9, 4 -> 0
		moves.put(4, Arrays.asList(new int[]{0, 2}, new int[]{2, 2}, new int[]{3, 1}));
		// 5..
		moves.put(5, new ArrayList<>());
		// 6 -> 1, 6 -> 7, 6 -> 0
		moves.put(6, Arrays.asList(new int[]{0, 0}, new int[]{2, 0}, new int[]{3, 1}));
		// 7 -> 2, 7 -> 6
		moves.put(7, Arrays.asList(new int[]{0, 1}, new int[]{1, 2}));
		// 8 -> 1, 8 -> 3
		moves.put(8, Arrays.asList(new int[]{0, 0}, new int[]{0, 2}));
		// 9 -> 4, 9 -> 2
		moves.put(9, Arrays.asList(new int[]{1, 0}, new int[]{0, 1}));
		// 0 -> 4, 0 -> 6
		moves.put(0, Arrays.asList(new int[]{1, 0}, new int[]{1, 2}));

		int res = 0;
		for (int i = 2; i <= n; i++) {
			int[][] nextMemo = new int[4][3];
			for (int row = 0; row < 4; row++) {
				for (int column = 0; column < 3; column++) {
					int currNum = grid[row][column];

					List<int[]> movesToNextNum = moves.get(currNum);

					for (int[] moveToNextNum : movesToNextNum) {
						int nextRow = moveToNextNum[0];
						int nextColumn = moveToNextNum[1];

						nextMemo[nextRow][nextColumn] = (nextMemo[nextRow][nextColumn] + memo[row][column]) % MOD;
					}
				}
			}

			memo = nextMemo;
		}

		for (int row = 0; row < 4; row++) {
			for (int column = 0; column < 3; column++) {
				res = (res + memo[row][column]) % MOD;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println(new KnightDialer().knightDialer(161));
		System.out.println(new KnightDialer().knightDialer(1));
		System.out.println(new KnightDialer().knightDialer(2));
		System.out.println(new KnightDialer().knightDialer(3));
	}
}
