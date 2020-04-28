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
		for (int i = 1; i <= s.length() / 2; i++)
		{
			if (repeatedSubstringPattern(s, s.substring(0, i), i, i))
			{
				return true;
			}
		}
		return false;
	}

	public boolean repeatedSubstringPattern(String string, String sub, int startPos, int length)
	{
		if (startPos == string.length())
		{
			return true;
		}

		if (startPos + length <= string.length() && sub.equals(string.substring(startPos, startPos + length)))
		{
			return repeatedSubstringPattern(string, sub, startPos + length, length);
		}
		return false;
	}
}
