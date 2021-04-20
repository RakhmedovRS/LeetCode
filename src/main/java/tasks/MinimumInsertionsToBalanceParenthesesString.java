package tasks;

import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 08-Aug-20
 */
@LeetCode(id = 1541, name = "Minimum Insertions to Balance a Parentheses String", url = "https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/")
public class MinimumInsertionsToBalanceParenthesesString
{
	public int minInsertions(String s)
	{
		int additions = 0;
		Deque<Character> characters = new LinkedList<>();
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == '(')
			{
				characters.push('(');
			}
			else
			{
				if (i + 1 < s.length() && s.charAt(i + 1) == ')')
				{
					if (characters.isEmpty())
					{
						additions++;
					}
					else
					{
						characters.pop();
					}
					i++;
				}
				else
				{
					if (characters.isEmpty())
					{
						additions += 2;
					}
					else
					{
						characters.pop();
						additions++;
					}
				}
			}
		}

		return additions + characters.size() * 2;
	}

	public static void main(String[] args)
	{
		System.out.println(new MinimumInsertionsToBalanceParenthesesString().minInsertions("))())("));
		System.out.println(new MinimumInsertionsToBalanceParenthesesString().minInsertions("(()))"));
		System.out.println(new MinimumInsertionsToBalanceParenthesesString().minInsertions("((((((")); //12
		System.out.println(new MinimumInsertionsToBalanceParenthesesString().minInsertions(")))))))")); //5
	}
}
