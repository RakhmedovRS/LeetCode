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
		Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
		return isMatch(s.toCharArray(), 0, p.toCharArray(), 0, memo);
	}

	private boolean isMatch(char[] string, int stringPos, char[] pattern, int patternPos, Boolean[][] memo)
	{
		if (patternPos == pattern.length)
		{
			return stringPos == string.length;
		}

		if (memo[stringPos][patternPos] != null)
		{
			return memo[stringPos][patternPos];
		}

		memo[stringPos][patternPos] = stringPos < string.length && (string[stringPos] == pattern[patternPos] || pattern[patternPos] == '.');

		if (patternPos + 1 < pattern.length && pattern[patternPos + 1] == '*')
		{
			memo[stringPos][patternPos] = isMatch(string, stringPos, pattern, patternPos + 2, memo)
				|| (memo[stringPos][patternPos] && isMatch(string, stringPos + 1, pattern, patternPos, memo));
		}
		else
		{
			memo[stringPos][patternPos] = memo[stringPos][patternPos] && isMatch(string, stringPos + 1, pattern, patternPos + 1, memo);
		}

		return memo[stringPos][patternPos];
	}

	public static void main(String[] args)
	{
		System.out.println(new RegularExpressionMatching().isMatch("ab", ".*"));
		System.out.println(new RegularExpressionMatching().isMatch("aab", "c*a*b"));
		System.out.println(new RegularExpressionMatching().isMatch("aa", "a"));
	}
}
