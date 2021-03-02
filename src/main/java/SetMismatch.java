import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 16-Jun-20
 */
@LeetCode(
	id = 645,
	name = "Set Mismatch",
	url = "https://leetcode.com/problems/set-mismatch/",
	difficulty = Difficulty.EASY
)
public class SetMismatch
{
	public int[] findErrorNums(int[] nums)
	{
		int[] counts = new int[nums.length + 1];
		for (int num : nums)
		{
			counts[num]++;
		}

		int[] answer = new int[2];
		for (int i = 1; i < counts.length; i++)
		{
			if (counts[i] > 1)
			{
				answer[0] = i;
			}

			if (counts[i] == 0)
			{
				answer[1] = i;
			}
		}

		return answer;
	}
}
