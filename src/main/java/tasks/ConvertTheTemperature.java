package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 11/19/2022
 */
@LeetCode(
        id = 2469,
        name = "Convert the Temperature",
        url = "https://leetcode.com/problems/convert-the-temperature/",
        difficulty = Difficulty.EASY
)
public class ConvertTheTemperature
{
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15D, celsius * 1.8D + 32};
    }
}
