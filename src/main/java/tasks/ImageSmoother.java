package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 27-May-20
 */
@LeetCode(id = 661, name = "Image Smoother", url = "https://leetcode.com/problems/image-smoother/")
public class ImageSmoother
{
	int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {0, -1}, {0, 0}, {1, 0}, {0, 1}, {1, 1}, {-1, 1}, {1, -1}};

	public int[][] imageSmoother(int[][] M)
	{
		int rows = M.length;
		int columns = M[0].length;
		int[][] answer = new int[M.length][M[0].length];
		int[] countAndSum;
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				countAndSum = new int[]{0, 0};
				for (int[] direction : directions)
				{
					int r = row + direction[0];
					int c = column + direction[1];
					if (r >= 0 && r < rows && c >= 0 && c < columns)
					{
						countAndSum[0]++;
						countAndSum[1] += M[r][c];
					}
				}
				answer[row][column] = countAndSum[1] / countAndSum[0];
			}
		}

		return answer;
	}
}
