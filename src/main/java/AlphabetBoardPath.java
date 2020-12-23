import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 12-Jun-20
 */
@LeetCode(
	id = 1138,
	name = "Alphabet Board Path",
	url = "https://leetcode.com/problems/alphabet-board-path/")
public class AlphabetBoardPath
{
	public String alphabetBoardPath(String target)
	{
		int[][] charToPos = new int[26][2];
		int row = 0;
		int column = 0;
		for (char ch = 'a'; ch <= 'z'; ch++)
		{
			if (column == 5)
			{
				row++;
				column = 0;
			}

			charToPos[ch - 'a'][0] = row;
			charToPos[ch - 'a'][1] = column;

			column++;
		}

		StringBuilder path = new StringBuilder();
		row = 0;
		column = 0;
		int targetRow;
		int targetColumn;
		for (char ch : target.toCharArray())
		{
			targetRow = charToPos[ch - 'a'][0];
			targetColumn = charToPos[ch - 'a'][1];

			while (row != targetRow || column != targetColumn)
			{
				while (row > targetRow)
				{
					row--;
					path.append("U");
				}

				while (column > targetColumn)
				{
					column--;
					path.append("L");
				}

				while (row < targetRow)
				{
					row++;
					path.append("D");
				}

				while (column < targetColumn)
				{
					column++;
					path.append("R");
				}

			}

			path.append("!");
		}

		return path.toString();
	}

	public static void main(String[] args)
	{
		System.out.println(new AlphabetBoardPath().alphabetBoardPath("code"));
		System.out.println(new AlphabetBoardPath().alphabetBoardPath("leet"));
	}
}
