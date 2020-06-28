import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 28-Jun-20
 */
@LeetCode(id = 1497, name = "Check If Array Pairs Are Divisible by k", url = "https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/")
public class CheckIfArrayPairsAreDivisibleByk
{
	public boolean canArrange(int[] arr, int k)
	{
		long sum = 0;
		for (int num : arr)
		{
			sum += num;
		}
		return sum % k == 0;
	}
}
