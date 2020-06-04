import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 04-Jun-20
 */
@LeetCode(id = 806, name = "Number of Lines To Write String", url = "https://leetcode.com/problems/number-of-lines-to-write-string/")
public class NumberOfLinesToWriteString
{
	public int[] numberOfLines(int[] widths, String S)
	{
		int lines = 0;
		int rest = 0;
		for (char ch : S.toCharArray())
		{
			if (rest + widths[ch - 'a'] > 100)
			{
				lines++;
				rest = widths[ch - 'a'];
			}
			else
			{
				rest += widths[ch - 'a'];
			}
		}

		return new int[]{lines + 1, rest};
	}
}
