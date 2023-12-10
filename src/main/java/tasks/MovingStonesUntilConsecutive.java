package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 21-Aug-20
 */
@LeetCode(id = 1033, name = "Moving Stones Until Consecutive", url = "https://leetcode.com/problems/moving-stones-until-consecutive/")
public class MovingStonesUntilConsecutive {
	public int[] numMovesStones(int a, int b, int c) {
		int sum = a + b + c;
		int min = Math.min(a, Math.min(b, c));
		int max = Math.max(a, Math.max(b, c));

		return moves(min, sum - min - max, max);
	}

	private int[] moves(int a, int b, int c) {
		if ((a + 1 == b && b + 1 == c) || (a - 1 == b && b - 1 == c)) {
			return new int[]{0, 0};
		}

		int min;
		if (b - a == 2 || c - b == 2 || b - a == 1 || c - b == 1) {
			min = 1;
		}
		else {
			min = 2;
		}

		int max = (b - a - 1) + (c - b - 1);

		return new int[]{min, max};
	}
}
