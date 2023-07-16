package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 2/19/2022
 */
@LeetCode(
		id = 2177,
		name = "Find Three Consecutive Integers That Sum to a Given Number",
		url = "https://leetcode.com/problems/find-three-consecutive-integers-that-sum-to-a-given-number/",
		difficulty = Difficulty.MEDIUM
)
public class FindThreeConsecutiveIntegersThatSumToGivenNumber
{
	public long[] sumOfThree(long num)
	{
		long left = 0;
		long right = num;
		long mid;
		long res;
		while (left <= right)
		{
			mid = (left + right) / 2;
			res = mid - 1 + mid + mid + 1;
			if (res == num)
			{
				return new long[]{mid - 1, mid, mid + 1};
			}
			else if (res < num)
			{
				left = mid + 1;
			}
			else
			{
				right = mid - 1;
			}
		}

		return new long[0];
	}
}
