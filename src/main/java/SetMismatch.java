import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 16-Jun-20
 */
@LeetCode(id = 645, name = "Set Mismatch", url = "https://leetcode.com/problems/set-mismatch/")
public class SetMismatch
{
	public int[] findErrorNums(int[] nums)
	{
		int[] answer = new int[2];
		int[] count = new int[nums.length + 1];
		for (int num : nums)
		{
			count[num]++;
		}

		for (int i = 1; i < count.length; i++)
		{
			if (count[i] == 2)
			{
				answer[0] = i;
			}

			if (count[i] == 0)
			{
				answer[1] = i;
			}
		}


		return answer;
	}
}
