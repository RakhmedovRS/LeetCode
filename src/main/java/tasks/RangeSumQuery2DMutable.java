package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/16/2020
 */
@LeetCode(
	id = 308,
	name = "Range Sum Query 2D - Mutable",
	url = "https://leetcode.com/problems/range-sum-query-2d-mutable/",
	difficulty = Difficulty.HARD,
	premium = true
)
public class RangeSumQuery2DMutable
{
	class FenwikTree
	{
		int[] original;
		int[] table;

		public FenwikTree(int[] nums)
		{
			original = new int[nums.length + 1];
			table = new int[nums.length + 1];
			System.arraycopy(nums, 0, original, 1, nums.length);

			int nextPos;
			for (int i = 1; i < table.length; i++)
			{
				table[i] += nums[i - 1];
				nextPos = i + (1 << getLeastSignificantBit(i));
				if (nextPos < table.length)
				{
					table[nextPos] += table[i];
				}
			}
		}

		public void update(int pos, int value)
		{
			int prev = original[pos + 1];
			original[pos + 1] = value;
			pos++;
			while (pos < table.length)
			{
				table[pos] -= prev;
				table[pos] += value;
				pos += 1 << getLeastSignificantBit(pos);
			}
		}

		public int getRangeSum(int i, int j)
		{
			return calcSum(j + 1) - calcSum(i);
		}

		private int calcSum(int pos)
		{
			int sum = 0;
			while (pos != 0)
			{
				sum += table[pos];
				pos -= 1 << getLeastSignificantBit(pos);
			}

			return sum;
		}

		private int getLeastSignificantBit(int number)
		{
			int i = 0;
			while ((number & (1 << i)) == 0)
			{
				i++;
			}

			return i;
		}
	}

	class NumMatrix
	{

		FenwikTree[] fenwikTrees;

		public NumMatrix(int[][] matrix)
		{
			fenwikTrees = new FenwikTree[matrix.length];
			for (int i = 0; i < fenwikTrees.length; i++)
			{
				fenwikTrees[i] = new FenwikTree(matrix[i]);
			}
		}

		public void update(int row, int col, int val)
		{
			fenwikTrees[row].update(col, val);
		}

		public int sumRegion(int row1, int col1, int row2, int col2)
		{
			int sum = 0;
			for (int i = row1; i <= row2; i++)
			{
				sum += fenwikTrees[i].getRangeSum(col1, col2);
			}

			return sum;
		}
	}
}
