package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 10/15/2022
 */
@LeetCode(
        id = 2437,
        name = "Number of Valid Clock Times",
        url = "https://leetcode.com/problems/number-of-valid-clock-times/",
        difficulty = Difficulty.EASY
)
public class NumberOfValidClockTimes
{
    public int countTime(String time)
    {
        int count = 0;
        outer:
        for (int i = 0; i < 1440; i++)
        {
            int hh = i / 60;
            int mm = i % 60;
            String t = "" + (hh < 10 ? "0" + hh : hh) + ":" + (mm < 10 ? "0" + mm : mm);

            for (int j = 0; j < time.length(); j++)
            {
                if (time.charAt(j) != '?' && time.charAt(j) != t.charAt(j))
                {
                    continue outer;
                }
            }

            count++;
        }

        return count;
    }
}
