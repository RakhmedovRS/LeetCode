import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/31/2020
 */
@LeetCode(id = 1639, name = "Number of Ways to Form a Target String Given a Dictionary", url = "https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/")
public class NumberOfWaysToFormTargetStringGivenDictionary
{
	public int numWays(String[] words, String target)
	{
		int[][] charFreq = new int[words[0].length()][26];
		for (int i = 0; i < charFreq.length; i++)
		{
			for (String word : words)
			{
				charFreq[i][word.charAt(i) - 'a']++;
			}
		}

		return (int) dfs(0, 0, words, target, charFreq, new Integer[charFreq.length][target.length()]);
	}

	private long dfs(int i, int j, String[] words, String target, int[][] charFreq, Integer[][] memo)
	{
		if (target.length() - j > words[0].length() - i)
		{
			return 0;
		}

		if (j == target.length())
		{
			return 1;
		}

		if (memo[i][j] != null)
		{
			return memo[i][j];
		}

		int matches = charFreq[i][target.charAt(j) - 'a'];
		long res = dfs(i + 1, j, words, target, charFreq, memo) + matches * dfs(i + 1, j + 1, words, target, charFreq, memo);
		memo[i][j] = (int)(res % 1_000_000_007);
		return memo[i][j];
	}

	public static void main(String[] args)
	{
		System.out.println(new NumberOfWaysToFormTargetStringGivenDictionary().numWays(new String[]
				{"cbabddddbc", "addbaacbbd", "cccbacdccd", "cdcaccacac", "dddbacabbd", "bdbdadbccb",
					"ddadbacddd", "bbccdddadd", "dcabaccbbd", "ddddcddadc", "bdcaaaabdd", "adacdcdcdd",
					"cbaaadbdbb", "bccbabcbab", "accbdccadd", "dcccaaddbc", "cccccacabd", "acacdbcbbc",
					"dbbdbaccca", "bdbddbddda", "daabadbacb", "baccdbaada", "ccbabaabcb", "dcaabccbbb",
					"bcadddaacc", "acddbbdccb", "adbddbadab", "dbbcdcbcdd", "ddbabbadbb", "bccbcbbbab",
					"dabbbdbbcb", "dacdabadbb", "addcbbabab", "bcbbccadda", "abbcacadac", "ccdadcaada",
					"bcacdbccdb"},
			"bcbbcccc"));

		System.out.println(new NumberOfWaysToFormTargetStringGivenDictionary().numWays(new String[]
			{"acca", "bbbb", "caca"}, "aba"));
	}
}
