import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 11/1/2020
 */
@LeetCode(id = 1640, name = "Check Array Formation Through Concatenation", url = "https://leetcode.com/problems/check-array-formation-through-concatenation/")
public class CheckArrayFormationThroughConcatenation
{
	public boolean canFormArray(int[] arr, int[][] pieces)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++)
		{
			map.put(arr[i], i);
		}

		int index;
		for (int[] piece : pieces)
		{
			index = map.getOrDefault(piece[0], arr.length);
			for (int i = 0; i < piece.length; i++)
			{
				if (index == arr.length || piece[i] != arr[index++])
				{
					return false;
				}
			}
		}

		return true;
	}
}
