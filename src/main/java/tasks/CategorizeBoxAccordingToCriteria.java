package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 1/7/2023
 */
@LeetCode(
        id = 2525,
        name = "Categorize Box According to Criteria",
        url = "https://leetcode.com/problems/categorize-box-according-to-criteria/description/",
        difficulty = Difficulty.EASY
)
public class CategorizeBoxAccordingToCriteria
{
    public String categorizeBox(int length, int width, int height, int mass)
    {
        boolean bulky = false;
        boolean heavy = false;

        long volume = (long) length * width * height;
        if (volume >= 1_000_000_000 || length >= 10_000 || width >= 10_000 || height >= 10_000)
        {
            bulky = true;
        }

        heavy = mass >= 100;

        if (bulky && heavy)
        {
            return "Both";
        }
        else if (bulky)
        {
            return "Bulky";
        }
        else if (heavy)
        {
            return "Heavy";
        }
        else
        {
            return "Neither";
        }
    }
}
