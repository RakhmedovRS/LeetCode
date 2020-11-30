import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/30/2020
 */
@LeetCode(
	id = 1133,
	name = "Largest Unique Number",
	url = "https://leetcode.com/problems/largest-unique-number/",
	difficulty = Difficulty.EASY,
	premium = true
)
public class LargestUniqueNumber
{
	public int largestUniqueNumber(int[] A)
	{
		int[] memo = new int[1001];
		for (int num : A)
		{
			memo[num]++;
		}

		for (int i = 1000; i >= 0; i--)
		{
			if (memo[i] == 1)
			{
				return i;
			}
		}
		return -1;
	}
}
