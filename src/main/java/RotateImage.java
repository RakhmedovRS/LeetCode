import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 29-Mar-20
 */
@LeetCode(id = 48, name = "Rotate Image", url = "https://leetcode.com/problems/rotate-image/")
public class RotateImage
{
	public void rotate(int[][] matrix)
	{
		if (matrix == null || matrix.length == 0)
		{
			return;
		}

		int size = matrix.length;

		for (int row = 0; row < size; row++)
		{
			for (int column = row; column < size; column++)
			{
				int temp = matrix[row][column];
				matrix[row][column] = matrix[column][row];
				matrix[column][row] = temp;
			}
		}

		int left;
		int right;
		for (int[] row : matrix)
		{
			left = 0;
			right = row.length - 1;
			while (left < right)
			{
				int temp = row[left];
				row[left] = row[right];
				row[right] = temp;
				left++;
				right--;
			}
		}
	}
}
