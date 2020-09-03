import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 28-Apr-20
 */
@LeetCode(id = 459, name = "Repeated Substring Pattern", url = "https://leetcode.com/problems/repeated-substring-pattern/")
public class RepeatedSubstringPattern
{
	public boolean repeatedSubstringPattern(String s)
	{
		String pattern;
		for (int i = 1; i <= s.length() / 2; i++)
		{
			pattern = s.substring(0, i);
			if (s.length() % pattern.length() == 0 && dfs(pattern, s, i))
			{
				return true;
			}
		}

		return false;
	}

	private boolean dfs(String pattern, String s, int startPos)
	{
		if (startPos == s.length())
		{
			return true;
		}

		if (startPos > s.length())
		{
			return false;
		}

		for (int i = 0; i < pattern.length(); i++)
		{
			if (s.charAt(startPos + i) != pattern.charAt(i))
			{
				return false;
			}
		}

		return dfs(pattern, s, startPos + pattern.length());
	}
}
