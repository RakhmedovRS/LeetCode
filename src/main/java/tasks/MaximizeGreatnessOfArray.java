package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Ruslan Rakhmedov
 * @created 3/19/2023
 */
@LeetCode(
        id = 2592,
        name = "Maximize Greatness of an Array",
        url = "https://leetcode.com/problems/maximize-greatness-of-an-array/",
        difficulty = Difficulty.MEDIUM
)
public class MaximizeGreatnessOfArray
{
    public int maximizeGreatness(int[] nums)
    {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int c = 0;
        for (int num : nums)
        {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(num + 1);
            if (entry != null)
            {
                c++;
                if (entry.getValue() == 1)
                {
                    map.remove(entry.getKey());
                }
                else
                {
                    map.put(entry.getKey(), entry.getValue() - 1);
                }
            }
        }

        return c;
    }
}
