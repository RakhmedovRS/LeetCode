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
		int[] rowMemo = new int[rows];
		int[] columnMemo = new int[columns];
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				rowMemo[row] += mat[row][column];
				columnMemo[column] += mat[row][column];
			}
		}

		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				if (mat[row][column] == 1 && rowMemo[row] == 1 && columnMemo[column] == 1)
				{
					count++;
				}
			}
		}

		return count;
	}

	public static void main(String[] args)
	{
		System.out.println(new SpecialPositionsInBinaryMatrix().numSpecial(new int[][]
			{
				{1, 0, 0},
				{0, 0, 1},
				{1, 0, 0}
			}
		));
	}
}
