import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 27-Jun-20
 */
@LeetCode(id = 1492, name = "The kth Factor of n", url = "https://leetcode.com/problems/the-kth-factor-of-n/")
public class TheKthFactorOfN
{
	public int kthFactor(int n, int k)
	{
		for (int i = 1; i <= n; i++)
		{
			if (n % i == 0)
			{
				if (--k == 0)
				{
					return i;
				}
			}
		}
		return -1;
	}
}
