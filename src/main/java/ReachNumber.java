import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/28/2020
 */
@LeetCode(
	id = 754,
	name = "Reach a Number",
	url = "https://leetcode.com/problems/reach-a-number/",
	difficulty = Difficulty.MEDIUM
)
public class ReachNumber
{
	public int reachNumber(int target)
	{
		int steps = 0;
		int sum = 0;
		target = Math.abs(target);
		for (int i = 1; sum < target; i++)
		{
			steps++;
			sum += i;
		}

		while ((sum - target) % 2 != 0)
		{
			steps++;
			sum += steps;
		}

		return steps;
	}
}
