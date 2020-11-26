import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 11/26/2020
 */
@LeetCode(
	id = 1220,
	name = "Count Vowels Permutation",
	url = "https://leetcode.com/problems/count-vowels-permutation/",
	difficulty = Difficulty.HARD
)
public class CountVowelsPermutation
{
	public int countVowelPermutation(int n)
	{
		Map<Character, List<Character>> transitions = new HashMap<>();
		transitions.put('a', Arrays.asList('e'));
		transitions.put('e', Arrays.asList('a', 'i'));
		transitions.put('i', Arrays.asList('a', 'e', 'o', 'u'));
		transitions.put('o', Arrays.asList('i', 'u'));
		transitions.put('u', Arrays.asList('a'));

		int mod = 1_000_000_007;

		int[][] memo = new int[n + 1][26];

		int answer = 0;
		for (Character ch : transitions.keySet())
		{
			answer = (answer + dfs(ch, n - 1, transitions, memo, mod) % mod) % mod;
		}

		return answer;
	}

	private int dfs(char ch, int n, Map<Character, List<Character>> transitions, int[][] memo, int mod)
	{
		if (n == 0)
		{
			return 1;
		}

		if (memo[n][ch - 'a'] != 0)
		{
			return memo[n][ch - 'a'];
		}

		int res = 0;
		for (Character next : transitions.get(ch))
		{
			res = (res + dfs(next, n - 1, transitions, memo, mod) % mod) % mod;
		}

		memo[n][ch - 'a'] = res;

		return res;
	}
}
