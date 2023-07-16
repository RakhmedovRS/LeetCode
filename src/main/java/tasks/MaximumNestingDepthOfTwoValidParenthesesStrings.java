package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 03-Feb-21
 */
@LeetCode(
		id = 1111,
		name = "Maximum Nesting Depth of Two Valid Parentheses Strings",
		url = "https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumNestingDepthOfTwoValidParenthesesStrings
{
	public int[] maxDepthAfterSplit(String seq)
	{
		int[] answer = new int[seq.length()];
		int c = 0;
		for (int i = 0; i < seq.length(); i++)
		{
			if (seq.charAt(i) == '(')
			{
				c++;
			}

			answer[i] = c % 2;

			if (seq.charAt(i) == ')')
			{
				c--;
			}

		}

		return answer;
	}
}
