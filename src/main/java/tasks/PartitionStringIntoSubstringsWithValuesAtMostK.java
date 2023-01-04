package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 1/3/2023
 * @$
 * @$
 */
@LeetCode(
        id = 2522,
        name = "Partition String Into Substrings With Values at Most K",
        url = "https://leetcode.com/problems/partition-string-into-substrings-with-values-at-most-k/",
        difficulty = Difficulty.MEDIUM
)
public class PartitionStringIntoSubstringsWithValuesAtMostK
{
    public int minimumPartition(String s, int k)
    {
        char[] chars = s.toCharArray();
        int pos = 0;

        int count = 0;
        while (pos < chars.length)
        {
            int prev = pos;
            long val = 0;
            for (; pos < chars.length; pos++)
            {
                if (val * 10 + chars[pos] - '0' <= k)
                {
                    val *= 10;
                    val += chars[pos] - '0';
                }
                else
                {
                    break;
                }
            }

            if (prev == pos)
            {
                return -1;
            }
            else
            {
                count++;
            }
        }

        return count;
    }
}
