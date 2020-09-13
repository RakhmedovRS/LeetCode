import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 13-Sep-20
 */
@LeetCode(id = 1582, name = "Special Positions in a Binary Matrix", url = "https://leetcode.com/problems/special-positions-in-a-binary-matrix/")
public class SpecialPositionsInBinaryMatrix
{
	public int numSpecial(int[][] mat)
	{
		int count = 0;
		int rows = mat.length;
		int columns = mat[0].length;
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				if (mat[row][column] == 1 && onlyOne(mat, row, column))
				{
					count++;
				}
			}
		}

		return count;
	}

	private boolean onlyOne(int[][] mat, int row, int column)
	{
		int ones = 0;
		for (int num : mat[row])
		{
			if (num == 1)
			{
				if (ones > 1)
				{
					return false;
				}
				ones++;
			}
		}

		for (int[] aRow : mat)
		{
			if (aRow[column] == 1)
			{
				if (ones > 1)
				{
					return false;
				}
				ones++;
			}
		}

		return ones == 2;
	}
}
