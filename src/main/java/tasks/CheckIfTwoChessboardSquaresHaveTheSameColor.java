package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-09-01
 */
@LeetCode(
		id = 3274,
		name = "Check if Two Chessboard Squares Have the Same Color",
		url = "https://leetcode.com/problems/check-if-two-chessboard-squares-have-the-same-color/description/",
		difficulty = Difficulty.EASY
)
public class CheckIfTwoChessboardSquaresHaveTheSameColor {
	public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
		Map<Character, boolean[]> board = new HashMap<>();
		boolean start = true;

		for (char ch = 'a'; ch <= 'h'; ch++) {
			boolean curr = start;
			board.put(ch, new boolean[10]);
			for (int i = 1; i < 9; i++) {
				board.get(ch)[i] = curr;
				curr = !curr;
			}
			start = !start;
		}

		return board.get(coordinate1.charAt(0))[coordinate1.charAt(1) - '0'] == board.get(coordinate2.charAt(0))[coordinate2.charAt(1) - '0'];
	}
}