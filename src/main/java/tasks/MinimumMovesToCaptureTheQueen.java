package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 1/7/2024
 */
@LeetCode(
		id = 3001,
		name = "Minimum Moves to Capture The Queen",
		url = "https://leetcode.com/problems/minimum-moves-to-capture-the-queen/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumMovesToCaptureTheQueen {
	public int minMovesToCaptureTheQueen(int rookRow, int rookColumn, int bishopRow, int bishopColumn, int queenRow, int queenColumn) {
		int rookSteps = 2;
		if (rookRow == queenRow || rookColumn == queenColumn) {
			rookSteps = 1;
		}
		if ((rookRow == bishopRow && rookRow == queenRow && Math.abs(rookColumn - queenColumn) > Math.abs(bishopColumn - queenColumn))
				|| rookColumn == bishopColumn && bishopColumn == queenColumn && Math.abs(rookRow - queenRow) > Math.abs(bishopRow - queenRow)) {
			rookSteps = 2;
		}

		int bishopSteps = Integer.MAX_VALUE;
		// up left
		for (int r = -1, c = -1; r >= -8; r--, c--) {
			if (bishopRow + r == rookRow && bishopColumn + c == rookColumn) {
				break;
			}
			if (bishopRow + r == queenRow && bishopColumn + c == queenColumn) {
				return 1;
			}

			if (canHitQueen(rookRow, rookColumn, bishopRow + r, bishopColumn + c, queenRow, queenColumn)) {
				bishopSteps = 2;
			}
		}

		// up right
		for (int r = -1, c = 1; r >= -8; r--, c++) {
			if (bishopRow + r == rookRow && bishopColumn + c == rookColumn) {
				break;
			}
			if (bishopRow + r == queenRow && bishopColumn + c == queenColumn) {
				return 1;
			}

			if (canHitQueen(rookRow, rookColumn, bishopRow + r, bishopColumn + c, queenRow, queenColumn)) {
				bishopSteps = 2;
			}
		}

		// left down
		for (int r = 1, c = -1; r <= 9; r++, c--) {
			if (bishopRow + r == rookRow && bishopColumn + c == rookColumn) {
				break;
			}
			if (bishopRow + r == queenRow && bishopColumn + c == queenColumn) {
				return 1;
			}

			if (canHitQueen(rookRow, rookColumn, bishopRow + r, bishopColumn + c, queenRow, queenColumn)) {
				bishopSteps = 2;
			}
		}

		//right down
		for (int r = 1, c = 1; r <= 8; r++, c++) {
			if (bishopRow + r == rookRow && bishopColumn + c == rookColumn) {
				break;
			}
			if (bishopRow + r == queenRow && bishopColumn + c == queenColumn) {
				return 1;
			}

			if (canHitQueen(rookRow, rookColumn, bishopRow + r, bishopColumn + c, queenRow, queenColumn)) {
				bishopSteps = 2;
			}
		}

		return Math.min(rookSteps, bishopSteps);
	}


	private boolean canHitQueen(int rookRow, int rookColumn, int bishopRow, int bishopColumn, int queenRow, int queenColumn) {
		// up left
		for (int r = -1, c = -1; r >= -8; r--, c--) {
			if (bishopRow + r == rookRow && bishopColumn + c == rookColumn) {
				break;
			}
			if (bishopRow + r == queenRow && bishopColumn + c == queenColumn) {
				return true;
			}
		}

		// up right
		for (int r = -1, c = 1; r >= -8; r--, c++) {
			if (bishopRow + r == rookRow && bishopColumn + c == rookColumn) {
				break;
			}
			if (bishopRow + r == queenRow && bishopColumn + c == queenColumn) {
				return true;
			}
		}

		// left down
		for (int r = 1, c = -1; r <= 9; r++, c--) {
			if (bishopRow + r == rookRow && bishopColumn + c == rookColumn) {
				break;
			}
			if (bishopRow + r == queenRow && bishopColumn + c == queenColumn) {
				return true;
			}
		}

		//right down
		for (int r = 1, c = 1; r <= 8; r++, c++) {
			if (bishopRow + r == rookRow && bishopColumn + c == rookColumn) {
				break;
			}
			if (bishopRow + r == queenRow && bishopColumn + c == queenColumn) {
				return true;
			}
		}

		return false;
	}
}
