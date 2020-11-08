import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/8/2020
 */
@LeetCode(id = 1646, name = "Get Maximum in Generated Array", url = "https://leetcode.com/problems/get-maximum-in-generated-array/")
public class GetMaximumInGeneratedArray
{
	public int getMaximumGenerated(int n)
	{
		if (n == 0)
		{
			return 0;
		}
		else if (n == 1)
		{
			return 1;
		}

		int[] values = new int[n + 1];
		values[0] = 0;
		values[1] = 1;
		for (int i = 2; i < values.length; i++)
		{
			if (i % 2 == 0)
			{
				values[i] = values[i / 2];
			}
			else
			{
				values[i] = values[i / 2] + values[i / 2 + 1];
			}
		}

		int max = 0;
		for (int val : values)
		{
			max = Math.max(max, val);
		}

		return max;
	}
}
