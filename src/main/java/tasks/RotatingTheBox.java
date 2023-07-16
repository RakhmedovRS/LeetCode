package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 5/15/2021
 */
@LeetCode(
		id = 1861,
		name = "Rotating the Box",
		url = "https://leetcode.com/problems/rotating-the-box/",
		difficulty = Difficulty.MEDIUM
)
public class RotatingTheBox
{
	public char[][] rotateTheBox(char[][] box)
	{
		int prevObstacle;
		for (char[] row : box)
		{
			prevObstacle = row.length - 1;
			for (int i = row.length - 1; i >= 0; i--)
			{
				if (row[i] == '*')
				{
					prevObstacle = i - 1;
				}
				else if (row[i] == '#')
				{
					row[i] = '.';
					row[prevObstacle--] = '#';
				}
			}
		}

		char[][] answer = new char[box[0].length][box.length];
		int c = 0;
		int r = 0;
		for (int row = box.length - 1; row >= 0; row--)
		{
			for (int column = 0; column < box[row].length; column++)
			{
				answer[r++][c] = box[row][column];
			}

			c++;
			r = 0;
		}

		return answer;
	}
}
