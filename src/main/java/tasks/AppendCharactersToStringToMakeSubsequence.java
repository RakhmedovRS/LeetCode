package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 12/1/2022
 * @$
 * @$
 */
@LeetCode(
        id = 2486,
        name = "Append Characters to String to Make Subsequence",
        url = "https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/",
        difficulty = Difficulty.MEDIUM
)
public class AppendCharactersToStringToMakeSubsequence
{
    public int appendCharacters(String s, String t)
    {
        int res = 0;
        int tPos = 0;
        for (char ch: s.toCharArray())
        {
            if (tPos < t.length() && t.charAt(tPos) == ch)
            {
                tPos++;
            }
        }

        if (tPos < t.length())
        {
            res += t.length() - tPos;
        }

        return res;
    }
}
