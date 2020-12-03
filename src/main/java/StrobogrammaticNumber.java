import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/3/2020
 */
@LeetCode(
	id = 246,
	name = "Strobogrammatic Number",
	url = "https://leetcode.com/problems/strobogrammatic-number/",
	difficulty = Difficulty.EASY,
	premium = true
)
public class StrobogrammaticNumber
{
	public boolean isStrobogrammatic(String origin)
	{
		StringBuilder rotated = new StringBuilder(origin.length());
		char digit;
		for (int i = origin.length() - 1; i >= 0; i--)
		{
			digit = origin.charAt(i);
			if (digit == '0' || digit == '1' || digit == '8')
			{
				rotated.append(digit);
			}
			else if (digit == '6')
			{
				rotated.append('9');
			}
			else if (digit == '9')
			{
				rotated.append('6');
			}
			else
			{
				return false;
			}
		}

		return origin.equals(rotated.toString());
	}
}
