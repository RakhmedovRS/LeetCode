import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 14-Aug-20
 */
@LeetCode(id = 949, name = "Largest Time for Given Digits", url = "https://leetcode.com/problems/largest-time-for-given-digits/")
public class LargestTimeForGivenDigits
{
	public String largestTimeFromDigits(int[] A)
	{
		int[] memo = new int[10];
		for (int num : A)
		{
			memo[num]++;
		}

		for (int i = 2; i >= 0; i--)
		{
			int h1 = findMaxWithBound(memo, i);
			int h2 = findMaxWithBound(memo, h1 == 2 ? 3 : 9);
			int m1 = findMaxWithBound(memo, 5);
			int m2 = findMaxWithBound(memo, 9);
			if (h1 != -1 && h2 != -1 && m1 != -1 && m2 != -1)
			{
				return h1 + "" + h2 + ":" + m1 + m2;
			}

			if (h1 != -1)
			{
				memo[h1]++;
			}
			if (h2 != -1)
			{
				memo[h2]++;
			}
			if (m1 != -1)
			{
				memo[m1]++;
			}
			if (m2 != -1)
			{
				memo[m2]++;
			}
		}

		return "";
	}

	private int findMaxWithBound(int[] memo, int start)
	{
		while (start >= 0 && memo[start] == 0)
		{
			start--;
		}

		if (start >= 0)
		{
			memo[start]--;
			return start;
		}

		return start;
	}
}
