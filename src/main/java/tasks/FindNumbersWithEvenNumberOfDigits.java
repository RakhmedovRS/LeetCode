package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 17-Apr-20
 */
@LeetCode(id = 1295, name = "Find Numbers with Even Number of Digits", url = "https://leetcode.com/problems/find-numbers-with-even-number-of-digits/")
public class FindNumbersWithEvenNumberOfDigits
{
	public int findNumbers(int[] nums)
	{
		int totalCount = 0;
		int count;
		for (int num : nums)
		{
			count = 0;
			while (num > 0)
			{
				num /= 10;
				count++;
			}
			if (count % 2 == 0)
			{
				totalCount++;
			}
		}

		return totalCount;
	}
}
