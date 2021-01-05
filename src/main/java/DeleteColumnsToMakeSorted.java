import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/5/2021
 */
@LeetCode(
	id = 944,
	name = "Delete Columns to Make Sorted",
	url = "https://leetcode.com/problems/delete-columns-to-make-sorted/",
	difficulty = Difficulty.EASY,
	premium = true
)
public class DeleteColumnsToMakeSorted
{
	public int minDeletionSize(String[] A)
	{
		int deletions = 0;
		int rows = A.length;
		if (rows == 0)
		{
			return deletions;
		}
		int columns = A[0].length();

		for (int column = 0; column < columns; column++)
		{
			for (int row = 0; row < rows - 1; row++)
			{
				if (A[row].charAt(column) > A[row + 1].charAt(column))
				{
					deletions++;
					break;
				}
			}
		}

		return deletions;
	}
}
