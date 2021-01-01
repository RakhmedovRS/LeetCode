import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 11/1/2020
 */
@LeetCode(
	id = 1640,
	name = "Check Array Formation Through Concatenation",
	url = "https://leetcode.com/problems/check-array-formation-through-concatenation/",
	difficulty = Difficulty.EASY
)
public class CheckArrayFormationThroughConcatenation
{
	public boolean canFormArray(int[] arr, int[][] pieces)
	{
		int[] memo = new int[101];
		Arrays.fill(memo, -1);

		for (int i = 0; i < arr.length; i++)
		{
			memo[arr[i]] = i;
		}

		int i;
		int j;
		for (int[] piece : pieces)
		{
			if (piece.length > 0)
			{
				i = 0;
				j = memo[piece[0]];
				while (i < piece.length && j != -1 && j < arr.length)
				{
					if (arr[j] != piece[i])
					{
						return false;
					}

					j++;
					memo[piece[i++]] = -1;
				}

				if (i < piece.length)
				{
					return false;
				}
			}
		}

		return true;
	}
}
