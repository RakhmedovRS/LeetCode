import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 06-Jun-20
 */
@LeetCode(id = 441, name = "Arranging Coins", url = "https://leetcode.com/problems/arranging-coins/")
public class ArrangingCoins
{
	public int arrangeCoins(int n)
	{
		long left = 0;
		long right = n;
		long k;
		long current;
		while (left <= right)
		{
			k = left + (right - left) / 2;
			current = k * (k + 1) / 2;

			if (current == n)
			{
				return (int) k;
			}

			if (n < current)
			{
				right = k - 1;
			}
			else
			{
				left = k + 1;
			}
		}
		return (int) right;
	}

	public static void main(String[] args)
	{
		System.out.println(new ArrangingCoins().arrangeCoins(5));
		System.out.println(new ArrangingCoins().arrangeCoins(8));
	}
}
