package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 7/8/2023
 */
@LeetCode(
        id = 2767,
        name = "Partition String Into Minimum Beautiful Substrings",
        url = "https://leetcode.com/problems/partition-string-into-minimum-beautiful-substrings/",
        difficulty = Difficulty.MEDIUM
)
public class PartitionStringIntoMinimumBeautifulSubstrings
{
    public int minimumBeautifulSubstrings(String s)
    {
        Set<Long> pows = new HashSet<>();
        for (int i = 0; i < 16; i++)
        {
            pows.add((long) Math.pow(5, i));
        }

        long res = dfs(0, s.toCharArray(), pows);
        if (res == 0 || res == Integer.MAX_VALUE)
        {
            return -1;
        }

        return (int) res;
    }

    private long dfs(int pos, char[] chars, Set<Long> pows)
    {
        if (pos >= chars.length)
        {
            return 0;
        }

        if (chars[pos] == '0')
        {
            return Integer.MAX_VALUE;
        }

        long min = Integer.MAX_VALUE;
        for (int i = pos; i < chars.length; i++)
        {
            if (pows.contains(toInt(pos, i, chars)))
            {
                long res = dfs(i + 1, chars, pows);
                if (res != Integer.MAX_VALUE)
                {
                    min = Math.min(min, 1 + res);
                    //print(pos, i, chars);
                }
            }
        }

        return min;
    }

    private long toInt(int s, int e, char[] chars)
    {
        int num = 0;
        int p = 0;
        while (e >= s)
        {
            if (chars[e--] == '1')
            {
                num += ((int) Math.pow(2, p));
            }
            p++;
        }

        return num;
    }
}
