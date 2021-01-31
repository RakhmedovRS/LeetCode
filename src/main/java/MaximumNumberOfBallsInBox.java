import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 31-Jan-21
 */
@LeetCode(
        id = 1742,
        name = "Maximum Number of Balls in a Box",
        url = "https://leetcode.com/problems/maximum-number-of-balls-in-a-box//",
        difficulty = Difficulty.EASY
)
public class MaximumNumberOfBallsInBox
{
    public int countBalls(int lowLimit, int highLimit)
    {
        int maxBalls = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum;
        int temp;
        for (int i = lowLimit; i <= highLimit; i++)
        {
            sum = 0;
            temp = i;
            while (temp > 0)
            {
                sum += temp % 10;
                temp /= 10;
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);

            maxBalls = Math.max(maxBalls, map.get(sum));
        }

        return maxBalls;
    }
}
