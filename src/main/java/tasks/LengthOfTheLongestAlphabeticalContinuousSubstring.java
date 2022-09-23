package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 9/23/2022
 * @$
 * @$
 */
@LeetCode(
        id = 2414,
        name = "Length of the Longest Alphabetical Continuous Substring",
        url = "https://leetcode.com/problems/length-of-the-longest-alphabetical-continuous-substring/",
        difficulty = Difficulty.MEDIUM
)
public class LengthOfTheLongestAlphabeticalContinuousSubstring
{
    public int longestContinuousSubstring(String s)
    {
        char[] chars = s.toCharArray();
        int[] memo = new int[s.length()];
        Arrays.fill(memo, 1);
        int max = 1;
        for (int i = 1; i < chars.length; i++)
        {
            if (chars[i - 1] == chars[i] - 1)
            {
                memo[i] += memo[i - 1];
                max = Math.max(max, memo[i]);
            }
        }

        return max;
    }
}
