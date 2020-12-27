import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/27/2020
 */
@LeetCode(
	id = 1704,
	name = "Determine if String Halves Are Alike",
	url = "https://leetcode.com/problems/determine-if-string-halves-are-alike/",
	difficulty = Difficulty.EASY
)
public class DetermineIfStringHalvesAreAlike
{
	public boolean halvesAreAlike(String s)
	{
		int a = 0;
		int b = 0;
		for (int i = 0; i < s.length(); i++)
		{
			char ch = Character.toLowerCase(s.charAt(i));

			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
			{
				if (i < s.length() / 2)
				{
					a++;
				}
				else
				{
					b++;
				}
			}
		}

		return a == b;
	}
}
