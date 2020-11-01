import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/1/2020
 */
@LeetCode(id = 1641, name = "Count Sorted Vowel Strings", url = "https://leetcode.com/problems/count-sorted-vowel-strings/")
public class CountSortedVowelStrings
{
	public int countVowelStrings(int n)
	{
		char[] dict = new char[]{'a', 'e', 'i', 'o', 'u'};
		return dfs(0, new char[n], n, dict, 0);
	}

	private int dfs(int pos, char[] curr, int n, char[] dict, int i)
	{
		if (n == 0)
		{
			return 1;
		}

		int count = 0;
		for (int j = i; j < dict.length; j++)
		{
			curr[pos] = dict[j];
			count += dfs(pos + 1, curr, n - 1, dict, j);
		}

		return count;
	}
}
