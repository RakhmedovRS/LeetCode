import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 13-Aug-20
 */
@LeetCode(id = 10, name = "Regular Expression Matching", url = "https://leetcode.com/problems/regular-expression-matching/")
public class RegularExpressionMatching
{
	public boolean isMatch(String s, String p)
	{
		char[] string = s.toCharArray();
		char[] pattern = p.toCharArray();
		Boolean[][] memo = new Boolean[string.length + 1][pattern.length + 1];
		return isMatch(0, 0, string, pattern, memo);
	}

	private boolean isMatch(int stringPos, int patternPos, char[] string, char[] pattern, Boolean[][] memo)
	{
		if (memo[stringPos][patternPos] != null)
		{
			return memo[stringPos][patternPos];
		}

		boolean match;
		if (patternPos == pattern.length)
		{
			match = stringPos == string.length;
		}
		else
		{
			match = stringPos < string.length && (string[stringPos] == pattern[patternPos] || pattern[patternPos] == '.');
			if (patternPos + 1 < pattern.length && pattern[patternPos + 1] == '*')
			{
				match = isMatch(stringPos, patternPos + 2, string, pattern, memo)
					|| (match && isMatch(stringPos + 1, patternPos, string, pattern, memo));
			}
			else
			{
				match = match && isMatch(stringPos + 1, patternPos + 1, string, pattern, memo);
			}
		}

		memo[stringPos][patternPos] = match;
		return match;
	}

	public static void main(String[] args)
	{
		System.out.println(new RegularExpressionMatching().isMatch("ab", ".*"));
		System.out.println(new RegularExpressionMatching().isMatch("aab", "c*a*b"));
		System.out.println(new RegularExpressionMatching().isMatch("aa", "a"));
	}
}
