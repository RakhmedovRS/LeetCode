package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/6/2020
 */
@LeetCode(id = 789, name = "Escape The Ghosts", url = "https://leetcode.com/problems/escape-the-ghosts/")
public class EscapeTheGhosts
{
	public boolean escapeGhosts(int[][] ghosts, int[] target)
	{
		int minMoves = Math.abs(target[0]) + Math.abs(target[1]);
		for (int[] ghost : ghosts)
		{
			if (minMoves >= (Math.abs(target[0] - ghost[0]) + Math.abs(target[1] - ghost[1])))
			{
				return false;
			}
		}

		return true;
	}
}
