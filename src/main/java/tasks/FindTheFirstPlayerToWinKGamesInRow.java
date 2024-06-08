package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-06-08
 */
@LeetCode(
		id = 3175,
		name = "Find The First Player to win K Games in a Row",
		url = "https://leetcode.com/problems/find-the-first-player-to-win-k-games-in-a-row/description/",
		difficulty = Difficulty.MEDIUM
)
public class FindTheFirstPlayerToWinKGamesInRow {
	public int findWinningPlayer(int[] skills, int k) {
		if (k > skills.length) {
			int maxI = 0;
			for (int i = 0; i < skills.length; i++) {
				if (skills[i] > skills[maxI]) {
					maxI = i;
				}
			}
			return maxI;
		}

		LinkedList<int[]> list = new LinkedList<>();
		for (int i = 0; i < skills.length; i++) {
			list.add(new int[]{skills[i], i, 0});
		}

		while (true) {
			int[] left = list.removeFirst();
			int[] right = list.removeFirst();

			if (left[0] > right[0]) {
				left[2]++;
				if (left[2] == k) {
					return left[1];
				}
				right[2] = 0;
				list.addFirst(left);
				list.addLast(right);
			} else {
				right[2]++;
				if (right[2] == k) {
					return right[1];
				}
				left[2] = 0;
				list.addFirst(right);
				list.addLast(left);
			}
		}
	}
}