import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 11/29/2020
 */
@LeetCode(
	id = 1673,
	name = "Find the Most Competitive Subsequence",
	url = "https://leetcode.com/problems/find-the-most-competitive-subsequence/",
	difficulty = Difficulty.MEDIUM
)
public class FindTheMostCompetitiveSubsequence
{
	public int[] mostCompetitive(int[] nums, int k)
	{
		if (nums.length == k)
		{
			return nums;
		}

		LinkedList<Integer> candidate = new LinkedList<>();
		for (int i = 0; i < nums.length; i++)
		{
			while (!candidate.isEmpty() && candidate.getLast() > nums[i] && candidate.size() + (nums.length - i) > k)
			{
				candidate.removeLast();
			}

			candidate.addLast(nums[i]);
		}

		int[] answer = new int[k];
		int pos = 0;
		while (k-- > 0)
		{
			answer[pos++] = candidate.removeFirst();
		}
		return answer;
	}
}
