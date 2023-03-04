package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 11/22/2022
 */
@LeetCode(
        id = 2472,
        name = "Maximum Number of Non-overlapping Palindrome Substrings",
        url = "https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings/",
        difficulty = Difficulty.HARD
)
public class MaximumNumberOfNonOverlappingPalindromeSubstrings
{
    public int maxPalindromes(String s, int k)
    {
        if (k == 1)
        {
            return s.length();
        }

        Integer[] memo = new Integer[s.length() + 1];
        dfs(s.toCharArray(), 0, k, memo);
        return memo[0];
    }

    private int dfs(char[] chars, int start, int k, Integer[] memo)
    {
        if (start >= chars.length)
        {
            return 0;
        }

        if (memo[start] != null)
        {
            return memo[start];
        }

        int max = 0;
        for (int end = start + k - 1, shift = 1; end < chars.length; end++, shift++)
        {
            if (isPalindrome(chars, start, end))
            {
                max = Math.max(max, 1 + dfs(chars, end + 1, k, memo));
            }

            max = Math.max(max, dfs(chars, start + shift, k, memo));
        }

        memo[start] = max;
        return max;
    }

    private boolean isPalindrome(char[] chars, int left, int right)
    {
        while (left <= right)
        {
            if (chars[left++] != chars[right--])
            {
                return false;
            }
        }
        return true;
    }
}
