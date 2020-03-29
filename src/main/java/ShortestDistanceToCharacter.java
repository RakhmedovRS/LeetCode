import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 24-Mar-20
 */
@LeetCode(id = 821, name = "Shortest Distance to a Character", url = "https://leetcode.com/problems/shortest-distance-to-a-character/")
public class ShortestDistanceToCharacter
{
	public int[] shortestToChar(String string, char ch)
	{
		if ("".equals(string) || string.length() == 0)
		{
			return new int[0];
		}

		int[] result = new int[string.length()];
		Arrays.fill(result, Integer.MAX_VALUE);

		for (int pos = 0; pos < string.length(); pos++)
		{
			if (string.charAt(pos) == ch)
			{
				result[pos] = 0;
				//going to the left
				for (int p = pos - 1; p >= 0; p--)
				{
					if (string.charAt(p) == ch)
					{
						break;
					}
					result[p] = Math.min(result[p], pos - p);
				}

				//going to the right
				for (int p = pos + 1; p < result.length; p++)
				{
					if (string.charAt(p) == ch)
					{
						break;
					}
					result[p] = Math.min(result[p], p - pos);
				}
			}
		}

		return result;
	}
}
