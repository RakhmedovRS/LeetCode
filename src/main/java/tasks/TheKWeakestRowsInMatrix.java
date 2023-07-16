package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 26-May-20
 */
@LeetCode(
		id = 1337,
		name = "The K Weakest Rows in a Matrix",
		url = "https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/",
		difficulty = Difficulty.EASY
)
public class TheKWeakestRowsInMatrix
{
	public int[] kWeakestRows(int[][] mat, int k)
	{
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) ->
		{
			if (a[1] == b[1])
			{
				return b[0] - a[0];
			}
			return b[1] - a[1];
		});

		int count;
		for (int i = 0; i < mat.length; i++)
		{
			count = 0;
			for (int j = 0; j < mat[i].length; j++)
			{
				count += mat[i][j];
			}

			maxHeap.add(new int[]{i, count});
			if (maxHeap.size() > k)
			{
				maxHeap.remove();
			}
		}

		int[] answer = new int[k];
		for (int i = k - 1; i >= 0; i--)
		{
			answer[i] = maxHeap.remove()[0];
		}

		return answer;
	}
}
