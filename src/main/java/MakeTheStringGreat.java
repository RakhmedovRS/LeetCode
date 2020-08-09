import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 09-Aug-20
 */
@LeetCode(id = 1544, name = "Make The String Great", url = "https://leetcode.com/problems/make-the-string-great/")
public class MakeTheStringGreat
{
	public String makeGood(String s)
	{
		Deque<Character> characters = new LinkedList<>();
		for (int i = 0; i < s.length(); i++)
		{
			if (!characters.isEmpty())
			{
				if (Character.toLowerCase(characters.peek()) == Character.toLowerCase(s.charAt(i)))
				{
					if (Character.isUpperCase(characters.peek()) && !Character.isUpperCase(s.charAt(i)))
					{
						characters.pop();
					}
					else if (!Character.isUpperCase(characters.peek()) && Character.isUpperCase(s.charAt(i)))
					{
						characters.pop();
					}
					else
					{
						characters.push(s.charAt(i));
					}
				}
				else
				{
					characters.push(s.charAt(i));
				}
			}
			else
			{
				characters.push(s.charAt(i));
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!characters.isEmpty())
		{
			sb.append(characters.remove());
		}

		return sb.reverse().toString();
	}
}
