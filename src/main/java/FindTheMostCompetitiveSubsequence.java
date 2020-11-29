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

		LinkedList<Integer> linkedList = new LinkedList<>();
		for (int i = 0; i < nums.length; i++)
		{
			while (!linkedList.isEmpty() && linkedList.getLast() > nums[i] && linkedList.size() + nums.length - i > k)
			{
				linkedList.removeLast();
			}

			linkedList.addLast(nums[i]);
		}

		int[] answer = new int[k];
		for (int i = 0; i < k; i++)
		{
			answer[i] = linkedList.removeFirst();
		}

		return answer;
	}
}
