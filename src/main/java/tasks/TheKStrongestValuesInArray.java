package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 11/24/2020
 */
@LeetCode(
	id = 1471,
	name = "The k Strongest Values in an Array",
	url = "https://leetcode.com/problems/the-k-strongest-values-in-an-array/",
	difficulty = Difficulty.MEDIUM
)
public class TheKStrongestValuesInArray
{
	public int[] getStrongest(int[] arr, int k)
	{
		if (k == arr.length)
		{
			return arr;
		}

		Arrays.sort(arr);
		int median = arr[(arr.length - 1) / 2];

		int pos = 0;
		int[] answer = new int[k];
		int left = 0;
		int right = arr.length - 1;
		while (k-- > 0)
		{
			if (Math.abs(arr[left] - median) > Math.abs(arr[right] - median))
			{
				answer[pos++] = arr[left++];
			}
			else if (Math.abs(arr[left] - median) <= Math.abs(arr[right] - median))
			{
				answer[pos++] = arr[right--];
			}
		}

		return answer;
	}
}
