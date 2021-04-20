package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 05-Jul-20
 */
@LeetCode(id = 1502, name = "Can Make Arithmetic Progression From Sequence", url = "https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/")
public class CanMakeArithmeticProgressionFromSequence
{
	public boolean canMakeArithmeticProgression(int[] arr)
	{
		Arrays.sort(arr);
		int diff = arr[1] - arr[0];
		for (int i = 1; i < arr.length; i++)
		{
			if (arr[i] - arr[i - 1] != diff)
			{
				return false;
			}
		}

		return true;
	}
}
