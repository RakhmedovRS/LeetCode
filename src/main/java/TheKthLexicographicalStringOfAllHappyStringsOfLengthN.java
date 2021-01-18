import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/18/2021
 */
@LeetCode(
	id = 1415,
	name = "The k-th Lexicographical String of All Happy Strings of Length n",
	url = "https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/",
	difficulty = Difficulty.MEDIUM
)
public class TheKthLexicographicalStringOfAllHappyStringsOfLengthN
{
	public String getHappyString(int n, int k)
	{
		char[] chars = new char[n];
		return dfs(0, chars, new int[]{k});
	}

	private String dfs(int pos, char[] chars, int[] k)
	{
		if (pos == chars.length)
		{
			k[0]--;
			if (k[0] == 0)
			{
				return String.valueOf(chars);
			}
			else
			{
				return "";
			}
		}

		String result = "";
		for (char ch = 'a'; ch <= 'c'; ch++)
		{
			if (pos > 0)
			{
				if (chars[pos - 1] != ch)
				{
					chars[pos] = ch;
					result = dfs(pos + 1, chars, k);
				}
			}
			else
			{
				chars[pos] = ch;
				result = dfs(pos + 1, chars, k);
			}

			if (result.length() > 0)
			{
				return result;
			}
		}

		return result;
	}
}
