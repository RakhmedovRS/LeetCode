package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 7/4/2022
 */
@LeetCode(
		id = 2326,
		name = "Spiral Matrix IV",
		url = "https://leetcode.com/problems/spiral-matrix-iv/",
		difficulty = Difficulty.MEDIUM
)
public class SpiralMatrixIV
{
	public int[][] spiralMatrix(int m, int n, ListNode head)
	{
		int[][] matrix = new int[m][n];
		for (int[] row : matrix)
		{
			Arrays.fill(row, -1);
		}

		int up = 0;
		int down = m - 1;
		int left = 0;
		int right = n - 1;
		while (head != null)
		{
			int l = left;
			while (l <= right && head != null)
			{
				matrix[up][l++] = head.val;
				head = head.next;
			}
			up++;

			int u = up;
			while (u <= down && head != null)
			{
				matrix[u++][right] = head.val;
				head = head.next;
			}
			right--;

			int r = right;
			while (r >= left && head != null)
			{
				matrix[down][r--] = head.val;
				head = head.next;
			}
			down--;

			int d = down;
			while (d >= up && head != null)
			{
				matrix[d--][left] = head.val;
				head = head.next;
			}
			left++;
		}

		return matrix;
	}
}
