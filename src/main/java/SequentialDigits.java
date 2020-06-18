import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 18.06.2020
 */
@LeetCode(id = 1291, name = "Sequential Digits", url = "https://leetcode.com/problems/sequential-digits/")
public class SequentialDigits
{
	public List<Integer> sequentialDigits(int low, int high)
	{
		List<Integer> result = new ArrayList<>();
		int[] seq = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
		int window = ("" + low).length();
		while (window < 10)
		{
			int left = 0;
			int right = left + window;
			while (right <= seq.length)
			{
				int val = 0;
				for (int i = left; i < right; i++)
				{
					val *= 10;
					val += seq[i];
				}

				if (val >= low && val <= high)
				{
					result.add(val);
				}
				if (val > high)
				{
					break;
				}
				left++;
				right++;
			}

			window++;
		}

		return result;
	}
}
