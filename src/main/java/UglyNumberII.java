import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 04-Jul-20
 */
@LeetCode(id = 264, name = "Ugly Number II", url = "https://leetcode.com/problems/ugly-number-ii/")
public class UglyNumberII
{
	public int nthUglyNumber(int n)
	{
		long[] ugly = new long[n + 1];
		ugly[0] = 1;
		int twoIdx = 0;
		int threeIdx = 0;
		int fiveIdx = 0;
		for (int i = 1; i < n; i++)
		{
			ugly[i] = Math.min(ugly[twoIdx] * 2, Math.min(ugly[threeIdx] * 3, ugly[fiveIdx] * 5));
			twoIdx += ugly[twoIdx] * 2 == ugly[i] ? 1 : 0;
			threeIdx += ugly[threeIdx] * 3 == ugly[i] ? 1 : 0;
			fiveIdx += ugly[fiveIdx] * 5 == ugly[i] ? 1 : 0;
		}

		return (int) ugly[n - 1];
	}
}
