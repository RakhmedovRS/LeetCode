import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @since 18.03.2021
 */
@LeetCode(
        id = 1794,
        name = "Count Pairs of Equal Substrings With Minimum Difference",
        url = "https://leetcode.com/problems/count-pairs-of-equal-substrings-with-minimum-difference/",
        difficulty = Difficulty.MEDIUM,
        premium = true
)
public class CountPairsOfEqualSubstringsWithMinimumDifference
{
    public int countQuadruples(String firstString, String secondString)
    {
        int[] tableA = new int[26];
        Arrays.fill(tableA, -1);
        char ch;
        for (int i = 0; i < firstString.length(); i++)
        {
            ch = firstString.charAt(i);
            if (tableA[ch - 'a'] == -1)
            {
                tableA[ch - 'a'] = i;
            }
        }

        int[] tableB = new int[26];
        Arrays.fill(tableB, -1);
        for (int i = secondString.length() - 1; i >= 0; i--)
        {
            ch = secondString.charAt(i);
            if (tableB[ch - 'a'] == -1)
            {
                tableB[ch - 'a'] = i;
            }
        }

        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < 26; i++)
        {
            if (tableA[i] == -1 || tableB[i] == -1)
            {
                continue;
            }

            if (tableA[i] - tableB[i] < min)
            {
                min = tableA[i] - tableB[i];
                count = 1;
            }
            else if (tableA[i] - tableB[i] == min)
            {
                count++;
            }
        }

        return count;
    }
}
