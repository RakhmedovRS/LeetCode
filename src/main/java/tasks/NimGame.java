package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 06-Jul-20
 */
@LeetCode(id = 292, name = "Nim Game", url = "https://leetcode.com/problems/nim-game/")
public class NimGame
{
	public boolean canWinNim(int n)
	{
		return (n % 4 != 0);
	}
}
