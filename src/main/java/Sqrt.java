import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12-Apr-20
 */
@LeetCode(id = 69, name = "Sqrt(x)", url = "https://leetcode.com/problems/sqrtx/")
public class Sqrt
{
	public int mySqrt(int x)
	{
		if (x == 0)
		{
			return 0;
		}

		if (x <= 3)
		{
			return 1;
		}

		int[] answer = new int[]{1};
		mySqrt(x, 1, x / 2, answer);
		return answer[0];
	}

	private void mySqrt(int x, long left, long right, int[] answer)
	{
		if (left > right)
		{
			return;
		}

		long mid = left + (right - left) / 2;
		long pow2 = mid * mid;
		if (pow2 == x)
		{
			answer[0] = (int)mid;
		}
		else if (pow2 > x)
		{
			mySqrt(x, left, mid - 1, answer);
		}
		else
		{
			if (pow2 > answer[0])
			{
				answer[0] = (int)mid;
			}
			mySqrt(x, mid + 1, right, answer);
		}
	}

	public static void main(String[] args)
	{
		System.out.println(new Sqrt().mySqrt(2147395599));
		System.out.println(new Sqrt().mySqrt(7));
		System.out.println(new Sqrt().mySqrt(10));
		System.out.println(new Sqrt().mySqrt(9));
		System.out.println(new Sqrt().mySqrt(16));
	}
}
