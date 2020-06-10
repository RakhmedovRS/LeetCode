import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10-Jun-20
 */
@LeetCode(id = 1249, name = "Minimum Remove to Make Valid Parentheses", url = "https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/")
public class MinimumRemoveToMakeValidParentheses
{
	public String minRemoveToMakeValid(String s)
	{
		StringBuilder stringBuilder = new StringBuilder();
		int open = 0;
		for (int i = 0; i < s.length(); i++)
		{
			char ch = s.charAt(i);
			if (ch == '(')
			{
				open++;
			}
			else if (ch == ')')
			{
				if (open <= 0)
				{
					continue;
				}
				open--;
			}
			stringBuilder.append(ch);
		}

		s = stringBuilder.toString();
		stringBuilder = new StringBuilder();
		int close = 0;
		for (int i = s.length() - 1; i >= 0; i--)
		{
			char ch = s.charAt(i);
			if (ch == ')')
			{
				close++;
			}
			else if (ch == '(')
			{
				if (close <= 0)
				{
					continue;
				}
				close--;
			}
			stringBuilder.append(ch);
		}

		return stringBuilder.reverse().toString();
	}
}
