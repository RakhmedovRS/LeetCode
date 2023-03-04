package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 9/12/2022
 */
@LeetCode(
        id = 2405,
        name = "Optimal Partition of String",
        url = "https://leetcode.com/problems/optimal-partition-of-string/",
        difficulty = Difficulty.MEDIUM
)
public class OptimalPartitionOfString
{
    public int partitionString(String s)
    {
        int count = 1;
        boolean[] seen = new boolean[26];
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if (seen[ch - 'a'])
            {
                count++;
                seen = new boolean[26];
            }

            seen[ch - 'a'] = true;
        }

        return count;
    }
}
