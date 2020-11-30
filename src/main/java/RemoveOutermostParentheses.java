import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/30/2020
 */
@LeetCode(
	id = 1021,
	name = "Remove Outermost Parentheses",
	url = "https://leetcode.com/problems/remove-outermost-parentheses/",
	difficulty = Difficulty.EASY
)
public class RemoveOutermostParentheses
{
	public String removeOuterParentheses(String S)
	{
		int balance = 0;
		int i = 0;
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < S.length(); j++)
		{
			if (S.charAt(j) == '(')
			{
				balance++;
			}
			else
			{
				balance--;
			}

			if (balance == 0)
			{
				sb.append(S, i + 1, j);
				i = j + 1;
			}
		}

		return sb.toString();
	}

	public static void main(String[] args)
	{
		System.out.println(new RemoveOutermostParentheses().removeOuterParentheses("()()"));
		System.out.println(new RemoveOutermostParentheses().removeOuterParentheses("(()())(())(()(()))"));
		System.out.println(new RemoveOutermostParentheses().removeOuterParentheses("(()())(())"));
	}
}
