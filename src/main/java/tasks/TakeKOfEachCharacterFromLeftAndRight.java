package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 12/28/2022
 */
@LeetCode(
        id = 2516,
        name = "Take K of Each Character From Left and Right",
        url = "https://leetcode.com/problems/take-k-of-each-character-from-left-and-right/",
        difficulty = Difficulty.MEDIUM
)
public class TakeKOfEachCharacterFromLeftAndRight
{
    public int takeCharacters(String s, int k)
    {
        int min = Integer.MAX_VALUE;
        int current = 0;
        int[] memo = new int[3];
        Arrays.fill(memo, k);
        int pos = 0;
        for (; pos < s.length() && !isValid(memo); pos++)
        {
            memo[s.charAt(pos) - 'a']--;
            current++;
        }

        if (!isValid(memo))
        {
            return -1;
        }

        min = current;

        pos--;

        for (int i = s.length() - 1; i >= 0; i--)
        {
            while (isValid(memo) && pos >= 0)
            {
                min = Math.min(min, current--);
                memo[s.charAt(pos--) - 'a']++;
            }

            memo[s.charAt(i) - 'a']--;
            current++;

            while (isValid(memo) && pos >= 0)
            {
                min = Math.min(min, current--);
                memo[s.charAt(pos--) - 'a']++;
            }

            if (isValid(memo))
            {
                min = Math.min(min, current);
            }
        }

        while (isValid(memo) && pos >= 0)
        {
            min = Math.min(min, current--);
            memo[s.charAt(pos--) - 'a']++;
        }

        return min;
    }

    boolean isValid(int[] memo)
    {
        return memo[0] <= 0 && memo[1] <= 0 && memo[2] <= 0;
    }
}
