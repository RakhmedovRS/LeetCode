import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/1/2020
 */
@LeetCode(id = 1071, name = "Greatest Common Divisor of Strings", url = "https://leetcode.com/problems/greatest-common-divisor-of-strings/")
public class GreatestCommonDivisorOfStrings
{
	public String gcdOfStrings(String str1, String str2)
	{
		String sub;
		String candidate = "";
		for (int pos = 1; pos <= str2.length(); pos++)
		{
			sub = str2.substring(0, pos);
			if (canBeDivided(str2, sub) && canBeDivided(str1, sub))
			{
				candidate = sub;
			}
		}

		return candidate;
	}

	private boolean canBeDivided(String a, String b)
	{
		if (a.length() % b.length() != 0 || a.length() < b.length())
		{
			return false;
		}

		for (int iA = 0, iB = 0; iA < a.length(); iA++, iB++)
		{
			if (a.charAt(iA) != b.charAt(iB % b.length()))
			{
				return false;
			}
		}
		return true;
	}
}
