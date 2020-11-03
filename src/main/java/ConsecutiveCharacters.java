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
		char prev = s.charAt(0);
		int power = 1;
		int maxPower = 1;
		for (int i = 1; i < s.length(); i++)
		{
			if (s.charAt(i) == prev)
			{
				power++;
			}
			else
			{
				prev = s.charAt(i);
				power = 1;
			}

			maxPower = Math.max(maxPower, power);
		}

		return maxPower;
	}
}
