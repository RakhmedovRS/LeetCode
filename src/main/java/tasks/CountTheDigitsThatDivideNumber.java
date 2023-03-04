package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 1/1/2023
 */
@LeetCode(
        id = 2520,
        name = "Count the Digits That Divide a Number",
        url = "https://leetcode.com/problems/count-the-digits-that-divide-a-number/",
        difficulty = Difficulty.EASY
)
public class CountTheDigitsThatDivideNumber
{
    public int countDigits(int num)
    {
        int cnt = 0;
        for (char ch: (""+num).toCharArray())
        {
            if (num % (ch - '0') == 0)
            {
                cnt++;
            }
        }
        return cnt;
    }
}
