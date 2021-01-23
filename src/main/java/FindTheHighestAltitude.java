import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/23/2021
 */
@LeetCode(
	id = 1732,
	name = "Find the Highest Altitude",
	url = "https://leetcode.com/problems/find-the-highest-altitude/",
	difficulty = Difficulty.EASY
)
public class FindTheHighestAltitude
{
	public int largestAltitude(int[] gain)
	{
		int max = 0;
		int sum = 0;
		for (int g : gain)
		{
			sum += g;
			max = Math.max(max, sum);
		}

		return max;
	}
}
