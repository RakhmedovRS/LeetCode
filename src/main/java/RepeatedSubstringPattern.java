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
		if (s == null || s.isEmpty())
		{
			return false;
		}

		int len = s.length();

		for (int i = len / 2; i >= 1; i--)
		{
			if (len % i == 0)
			{
				int repeat = len / i;
				String substring = s.substring(0, i);
				StringBuilder stringBuilder = new StringBuilder();
				for (int j = 0; j < repeat; j++)
				{
					stringBuilder.append(substring);
				}

				if (stringBuilder.toString().equals(s))
				{
					return true;
				}
			}
		}

		return false;
	}
}
