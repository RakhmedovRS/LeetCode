package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 10/3/2021
 */
@LeetCode(
		id = 2027,
		name = "Minimum Moves to Convert String",
		url = "https://leetcode.com/problems/minimum-moves-to-convert-string/",
		difficulty = Difficulty.EASY
)
public class MinimumMovesToConvertString {
	public int minimumMoves(String s) {
		int moves = 0;
		char[] chars = s.toCharArray();
		LinkedList<Character> list = new LinkedList<>();
		for (char ch : chars) {
			if (list.size() == 3) {
				while (!list.isEmpty() && list.getFirst() == 'O') {
					list.removeFirst();
				}

				if (list.size() == 3) {
					list.clear();
					moves++;
				}
			}

			list.addLast(ch);
		}

		while (!list.isEmpty() && list.getFirst() == 'O') {
			list.removeFirst();
		}

		if (!list.isEmpty()) {
			moves++;
		}

		return moves;
	}
}
