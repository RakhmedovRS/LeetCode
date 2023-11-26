package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 11/25/2023
 */
@LeetCode(
		id = 2946,
		name = "Matrix Similarity After Cyclic Shifts",
		url = "https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/",
		difficulty = Difficulty.EASY
)
public class MatrixSimilarityAfterCyclicShifts
{
	public boolean areSimilar(int[][] mat, int k) {
		Map<Integer, LinkedList<Integer>> matrix = new HashMap<>();
		for (int row = 0; row < mat.length; row++)
		{
			LinkedList<Integer> r = new LinkedList<>();
			for (int col = 0; col < mat[row].length; col++)
			{
				r.addLast(mat[row][col]);
			}

			matrix.put(row, r);
		}

		for (Map.Entry<Integer, LinkedList<Integer>> entry: matrix.entrySet())
		{
			for (int i = 0; i < k; i++)
			{
				if (entry.getKey() % 2 == 0)
				{
					entry.getValue().addLast(entry.getValue().removeFirst());
				}
				else
				{
					entry.getValue().addFirst(entry.getValue().removeLast());
				}
			}
		}

		for (int row = 0; row < mat.length; row++)
		{
			LinkedList<Integer> r = matrix.get(row);
			for (int col = 0; col < mat[row].length; col++)
			{
				if (mat[row][col] != r.removeFirst())
				{
					return false;
				}
			}

			matrix.put(row, r);
		}


		return true;
	}
}
