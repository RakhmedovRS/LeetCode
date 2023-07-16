package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 4/4/2021
 */
@LeetCode(
		id = 1812,
		name = "Determine Color of a Chessboard Square",
		url = "https://leetcode.com/problems/determine-color-of-a-chessboard-square/",
		difficulty = Difficulty.EASY
)
public class DetermineColorOfChessboardSquare
{
	public boolean squareIsWhite(String coordinates)
	{
		if ((coordinates.charAt(0) - 'a') % 2 == 0)
		{
			return (coordinates.charAt(1) - '0') % 2 == 0;
		}
		else
		{
			return (coordinates.charAt(1) - '0') % 2 != 0;
		}
	}
}
