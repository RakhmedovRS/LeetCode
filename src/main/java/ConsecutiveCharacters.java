import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 17-May-20
 */
@LeetCode(id = 1446, name = "Consecutive Characters", url = "https://leetcode.com/problems/consecutive-characters/")
public class ConsecutiveCharacters
{
	public int maxPower(String s)
	{
		if (s == null || s.isEmpty())
		{
			return 0;
		}

		int max = 1;
		int current = 0;
		for (int i = 1; i < s.length(); i++)
		{
			if (s.charAt(i) == s.charAt(i - 1))
			{
				current++;
			}
			else
			{
				if (current > max)
				{
					max = current;
				}
				current = 0;
			}
		}

		return max;
	}
}
