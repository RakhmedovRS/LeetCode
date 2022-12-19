package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 12/18/2022
 * @$
 * @$
 */
@LeetCode(
        id = 2506,
        name = "Count Pairs Of Similar Strings",
        url = "https://leetcode.com/problems/count-pairs-of-similar-strings/description/",
        difficulty = Difficulty.EASY
)
public class CountPairsOfSimilarStrings
{
    public int similarPairs(String[] words)
    {
        boolean[][] memo = new boolean[words.length][26];
        for (int i = 0; i < words.length; i++)
        {
            for (char ch : words[i].toCharArray())
            {
                memo[i][ch - 'a'] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < memo.length; i++)
        {
            outer:
            for (int j = i + 1; j < memo.length; j++)
            {
                for (int ch = 'a'; ch <= 'z'; ch++)
                {
                    if (memo[i][ch - 'a'] != memo[j][ch - 'a'])
                    {
                        continue outer;
                    }
                }
                count++;
            }
        }

        return count;
    }
}
