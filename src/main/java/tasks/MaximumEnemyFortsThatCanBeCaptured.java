package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 12/24/2022
 */
@LeetCode(
        id = 2511,
        name = "Maximum Enemy Forts That Can Be Captured",
        url = "https://leetcode.com/problems/maximum-enemy-forts-that-can-be-captured/description/",
        difficulty = Difficulty.EASY
)
public class MaximumEnemyFortsThatCanBeCaptured
{
    public int captureForts(int[] forts)
    {
        int current = 0;
        int max = 0;
        boolean[] lTrOne = new boolean[forts.length];
        boolean[] lTrMinus = new boolean[forts.length];
        boolean[] rTlOne = new boolean[forts.length];
        boolean[] rTlMinus = new boolean[forts.length];

        for (int i = 0; i < forts.length; i++)
        {
            if (i > 0)
            {
                lTrOne[i] = forts[i] != -1 && (lTrOne[i - 1] || forts[i] == 1);
                lTrMinus[i] = forts[i] != 1 && (lTrMinus[i - 1] || forts[i] == -1);
            }
            else
            {
                lTrOne[i] = forts[i] == 1;
                lTrMinus[i] = forts[i] == -1;
            }
        }

        for (int i = forts.length - 1; i >= 0; i--)
        {
            if (i < forts.length - 1)
            {
                rTlOne[i] = forts[i] != -1 && (rTlOne[i + 1] || forts[i] == 1);
                rTlMinus[i] = forts[i] != 1 && (rTlMinus[i + 1] || forts[i] == -1);
            }
            else
            {
                rTlOne[i] = forts[i] == 1;
                rTlMinus[i] = forts[i] == -1;
            }
        }

        for (int i = 1; i < forts.length - 1; i++)
        {
            if (forts[i] == 0)
            {
                if (lTrOne[i] && rTlMinus[i])
                {
                    current++;
                }
                else if (lTrMinus[i] && rTlOne[i])
                {
                    current++;
                }
            }
            else
            {
                max = Math.max(max, current);
                current = 0;
            }
        }

        max = Math.max(max, current);

        return max;
    }
}
