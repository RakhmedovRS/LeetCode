import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 16-Aug-20
 */
@LeetCode(
	id = 1551,
	name = "Minimum Operations to Make Array Equal",
	url = "https://leetcode.com/problems/minimum-operations-to-make-array-equal/",
	difficulty = Difficulty.MEDIUM
)
public class MinimumOperationsToMakeArrayEqual
{
	public int minOperations(int n)
	{
		int operations = 0;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
		{
			arr[i] = i * 2 + 1;
		}

		for (int i = 0, j = n - 1; i < j; i++, j--)
		{
			operations += arr[j] - arr[i];
		}

		return operations;
	}

	public static void main(String[] args)
	{
		System.out.println(new MinimumOperationsToMakeArrayEqual().minOperations(3));
	}
}
