import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 06-Sep-20
 */
@LeetCode(id = 835, name = "Image Overlap", url = "https://leetcode.com/problems/image-overlap/")
public class ImageOverlap
{
	public int largestOverlap(int[][] A, int[][] B)
	{
		int maxOverlaps = 0;

		for (int yShift = 0; yShift < A.length; yShift++)
			for (int xShift = 0; xShift < A.length; xShift++)
			{
				// move one of the matrices up and left and vice versa.
				// (equivalent to move the other matrix down and right)
				maxOverlaps = Math.max(maxOverlaps, shiftAndCount(xShift, yShift, A, B));
				maxOverlaps = Math.max(maxOverlaps, shiftAndCount(xShift, yShift, B, A));
			}

		return maxOverlaps;
	}

	private int shiftAndCount(int xShift, int yShift, int[][] M, int[][] R)
	{
		int count = 0;
		int rRow = 0;
		// count the cells of ones in the overlapping zone.
		for (int mRow = yShift; mRow < M.length; ++mRow)
		{
			int rCol = 0;
			for (int mCol = xShift; mCol < M.length; ++mCol)
			{
				if (M[mRow][mCol] == 1 && M[mRow][mCol] == R[rRow][rCol])
				{
					count += 1;
				}
				rCol += 1;
			}
			rRow += 1;
		}
		return count;
	}
}
