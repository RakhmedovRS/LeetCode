package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/5/2021
 */
@LeetCode(
	id = 1216,
	name = "Valid Palindrome III",
	url = "https://leetcode.com/problems/valid-palindrome-iii/",
	difficulty = Difficulty.HARD,
	premium = true
)
public class ValidPalindromeIII
{
	public boolean isValidPalindrome(String s, int k)
	{
		int n = s.length();
		int l = dfs(0, s.length() - 1, s.toCharArray(), new Integer[n][n]);
		return l >= n - k;
	}

	private int dfs(int left, int right, char[] chars, Integer[][] memo)
	{
		if (left == right)
		{
			return 1;
		}
		else if (left > right)
		{
			return 0;
		}

		if (memo[left][right] != null)
		{
			return memo[left][right];
		}

		if (chars[left] == chars[right])
		{
			memo[left][right] = Math.max(2 + dfs(left + 1, right - 1, chars, memo),
				Math.max(dfs(left + 1, right, chars, memo), dfs(left, right - 1, chars, memo)));
		}
		else
		{
			memo[left][right] = Math.max(dfs(left + 1, right - 1, chars, memo),
				Math.max(dfs(left + 1, right, chars, memo), dfs(left, right - 1, chars, memo)));
		}

		return memo[left][right];
	}

	public static void main(String[] args)
	{
		ValidPalindromeIII clazz = new ValidPalindromeIII();

		System.out.println(clazz.isValidPalindrome("bacabaaa", 2));
		System.out.println(clazz.isValidPalindrome("baacacaa", 1));

		System.out.println(clazz.isValidPalindrome(
			"dadaabbdddcabbccdcaabadbbcccbacdcacacbdbabbadcdabacbadcdabcbbaacdabbdcbabdcbbbcaddccbdbbaaadcbaabaadbadcd" +
				"adcdcddddcdbbddcbddbbdbabababcbdabddabcdcbcaaaacbbbdcbabbbcaacbcbacaaabccdbdddbbcbbbcacacbbdccacacddaabc" +
				"cbaccddcbdcbcacadbaacccbaabaccdaddbdadcccbbbcbbbdcbbacacbabdcddcbbbccdcbbabddcbbabbacdcadcaaddcdcdaaccad" +
				"bcdacbbdccaccdaaaabbcdcadddadcddbdccadabcbbadbbdbbaccbdadbdbbdcaccccccaddaaacbadcbbacbbbddacbadbdabdcbca" +
				"cadbcdabbdbaddcdcabbbbabbacdacbacdaccbcbbcaccbabcbdbaccacddccdbabcbaadadacadabacddadadcbdaacdbd", 216));
	}
}
