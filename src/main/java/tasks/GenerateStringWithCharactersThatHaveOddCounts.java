package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 24-May-20
 */
@LeetCode(id = 1374, name = "Generate a String With Characters That Have Odd Counts", url = "https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/")
public class GenerateStringWithCharactersThatHaveOddCounts
{
	public String generateTheString(int n)
	{
		StringBuilder builder = new StringBuilder();
		if (n % 2 == 0)
		{
			builder.append('a');
			n--;
		}

		while (n-- > 0)
		{
			builder.append('b');
		}

		return builder.toString();
	}
}
