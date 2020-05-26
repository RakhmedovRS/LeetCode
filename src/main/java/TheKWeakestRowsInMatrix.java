import common.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 26-May-20
 */
@LeetCode(id = 1337, name = "The K Weakest Rows in a Matrix", url = "https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/")
public class TheKWeakestRowsInMatrix
{
	public int[] kWeakestRows(int[][] mat, int k)
	{
		Map<Integer, Integer> memo = new HashMap<>();
		for (int i = 0; i < mat.length; i++)
		{
			memo.put(i, sum(mat[i]));
		}

		int[] answer = new int[k];
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((v1, v2) ->
		{
			int a = memo.get(v1);
			int b = memo.get(v2);
			if (a == b)
			{
				return v1 - v2;
			}
			else
			{
				return a - b;
			}
		});
		minHeap.addAll(memo.keySet());
		int i = 0;
		while (i < k)
		{
			answer[i++] = minHeap.poll();
		}
		return answer;
	}

	private int sum(int[] line)
	{
		if (line[0] == 0)
		{
			return 0;
		}
		else if (line[line.length - 1] == 1)
		{
			return line.length;
		}

		int left = 0;
		int right = line.length - 1;
		int middle;
		while (left <= right)
		{
			middle = left + (right - left) / 2;
			if (line[middle] == 1)
			{
				left = middle + 1;
			}
			else
			{
				right = middle - 1;
			}
		}

		return left;
	}
}
