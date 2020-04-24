import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 24-Apr-20
 */
@LeetCode(id = 498, name = "Diagonal Traverse", url = "https://leetcode.com/problems/diagonal-traverse/")
public class DiagonalTraverse
{
	public int[] findDiagonalOrder(int[][] matrix)
	{
		if (matrix == null || matrix.length == 0)
		{
			return new int[]{};
		}

		int rows = matrix.length - 1;
		int columns = matrix[0].length - 1;

		int pos = 0;
		int row = 0;
		int column = 0;
		int[] res = new int[matrix.length * matrix[0].length];
		boolean down = false;
		while (row != rows || column != columns)
		{
			if (down)
			{
				while (row <= rows && column >= 0)
				{
					res[pos++] = matrix[row++][column--];
				}

				row--;
				column++;

				if (row < rows)
				{
					row++;
				}
				else
				{
					column++;
				}
			}
			else
			{
				while (row >= 0 && column <= columns)
				{
					res[pos++] = matrix[row--][column++];
				}

				row++;
				column--;

				if (column < columns)
				{
					column++;
				}
				else
				{
					row++;
				}
			}

			down = !down;
		}

		res[pos] = matrix[row][column];

		return res;
	}
}
