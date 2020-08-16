import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 16-Aug-20
 */
@LeetCode(id = 1551, name = "Minimum Operations to Make Array Equal", url = "https://leetcode.com/problems/minimum-operations-to-make-array-equal/")
public class MinimumOperationsToMakeArrayEqual
{
	public int minOperations(int n)
	{
		int min = 0;
		int sum = 0;
		for (int i = 0; i < n; i++)
		{
			sum += i * 2 + 1;
		}

		int mid = sum / n;
		for (int i = 0; i * 2 + 1 < mid; i++)
		{
			min += mid - (i * 2 + 1);
		}

		return min;
	}

	public static void main(String[] args)
	{
		System.out.println(new MinimumOperationsToMakeArrayEqual().minOperations(3));
	}
}
