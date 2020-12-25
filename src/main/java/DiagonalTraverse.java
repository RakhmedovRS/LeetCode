import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 24-Apr-20
 */
@LeetCode(
	id = 498,
	name = "Diagonal Traverse",
	url = "https://leetcode.com/problems/diagonal-traverse/",
	difficulty = Difficulty.MEDIUM
)
public class DiagonalTraverse
{
	public int[] findDiagonalOrder(int[][] matrix)
	{
		int pos = 0;
		int rows = matrix.length;
		if (rows == 0)
		{
			return new int[0];
		}
		int columns = matrix[0].length;
		int[] answer = new int[rows * columns];
		int row = 0;
		int column = 0;
		boolean goingUp = true;
		while (pos < answer.length)
		{
			answer[pos++] = matrix[row][column];

			if (goingUp)
			{
				if (column == columns - 1)
				{
					row++;
					goingUp = false;
				}
				else if (row == 0)
				{
					column++;
					goingUp = false;
				}
				else
				{
					row--;
					column++;
				}
			}
			else
			{
				if (row == rows - 1)
				{
					column++;
					goingUp = true;
				}
				else if (column == 0)
				{
					row++;
					goingUp = true;
				}
				else
				{
					row++;
					column--;
				}
			}
		}

		return answer;
	}
}
