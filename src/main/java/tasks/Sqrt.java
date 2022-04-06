package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12-Apr-20
 */
@LeetCode(
	id = 69,
	name = "Sqrt(x)",
	url = "https://leetcode.com/problems/sqrtx/",
	difficulty = Difficulty.EASY
)
public class Sqrt
{
	public int mySqrt(int x)
	{
		if (x < 2)
		{
			return x;
		}

		int left = 2;
		int right = x / 2;
		int mid;
		long pivot;
		while (left <= right)
		{
			mid = left + (right - left) / 2;
			pivot = 1l * mid * mid;
			if (pivot == x)
			{
				return mid;
			}
			else if (pivot > x)
			{
				right = mid - 1;
			}
			else
			{
				left = mid + 1;
			}
		}

		return right;
	}

	public static void main(String[] args)
	{
		System.out.println(new Sqrt().mySqrt(9));
		System.out.println(new Sqrt().mySqrt(2147395599));
		System.out.println(new Sqrt().mySqrt(4));
		System.out.println(new Sqrt().mySqrt(10));
		System.out.println(new Sqrt().mySqrt(9));
		System.out.println(new Sqrt().mySqrt(16));
	}
}
