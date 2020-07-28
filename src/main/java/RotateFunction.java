import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 28-Jul-20
 */
@LeetCode(id = 396, name = "Rotate Function", url = "https://leetcode.com/problems/rotate-function/")
public class RotateFunction
{
	public int maxRotateFunction(int[] A)
	{
		if (A == null || A.length == 0)
		{
			return 0;
		}

		long max = Integer.MIN_VALUE;
		int pos = 0;
		for (int i = 0; i < A.length; i++)
		{
			int currPos = pos + 1 == A.length ? 0 : pos + 1;
			int current = 1;
			long sum = 0;
			while (currPos != pos)
			{
				sum += current * A[currPos];
				currPos = currPos + 1 == A.length ? 0 : currPos + 1;
				current++;
			}

			max = Math.max(max, sum);

			pos = pos - 1 < 0 ? A.length - 1 : pos - 1;
		}

		return (int) max;
	}
}
