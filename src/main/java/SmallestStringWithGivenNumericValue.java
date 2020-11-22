import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/22/2020
 */
@LeetCode(
	id = 1663,
	name = "Smallest String With A Given Numeric Value",
	url = "https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/",
	difficulty = Difficulty.MEDIUM
)
public class SmallestStringWithGivenNumericValue
{
	public String getSmallestString(int n, int k)
	{
		StringBuilder sb = new StringBuilder();
		while (n > 0)
		{
			int ch = 1;
			while (k - ch > ((n - 1) * 26))
			{
				ch++;
			}

			sb.append((char) (ch - 1 + 'a'));

			k -= ch;
			n--;
		}

		return sb.toString();
	}
}
