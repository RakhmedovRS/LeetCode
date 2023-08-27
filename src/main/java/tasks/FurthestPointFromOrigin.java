package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 8/26/2023
 */
@LeetCode(
		id = 2833,
		name = "Furthest Point From Origin",
		url = "https://leetcode.com/problems/furthest-point-from-origin/",
		difficulty = Difficulty.EASY
)
public class FurthestPointFromOrigin
{
	public int furthestDistanceFromOrigin(String moves) {
		int pos1 = 0;
		int pos2 = 0;
		for (char ch: moves.toCharArray())
		{
			if (ch == 'L' || ch == '_')
			{
				pos1--;
			}
			else
			{
				pos1++;
			}
		}

		for (char ch: moves.toCharArray())
		{
			if (ch == 'R' || ch == '_')
			{
				pos2++;
			}
			else
			{
				pos2--;
			}
		}

		return Math.max(Math.abs(pos1), Math.abs(pos2));
	}
}
