package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 11/4/2023
 */
@LeetCode(
		id = 2923,
		name = "Find Champion I",
		url = "https://leetcode.com/problems/find-champion-i/",
		difficulty = Difficulty.EASY
)
public class FindChampionI {
	public int findChampion(int[][] grid) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (i != j) {
					if (grid[i][j] == 1) {
						map.putIfAbsent(i, new ArrayList<>());
						map.get(i).add(j);
					}
					else {
						map.putIfAbsent(j, new ArrayList<>());
						map.get(j).add(i);
					}
				}
			}
		}

		boolean[] winner = new boolean[grid[0].length];
		Arrays.fill(winner, true);
		for (List<Integer> weak : map.values()) {
			for (int w : weak) {
				winner[w] = false;
			}
		}

		for (int i = 0; i < winner.length; i++) {
			if (winner[i]) {
				return i;
			}
		}

		return 0;
	}
}
