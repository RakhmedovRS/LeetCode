package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 10/1/2022
 */
@LeetCode(
        id = 2423,
        name = "Remove Letter To Equalize Frequency",
        url = "https://leetcode.com/problems/remove-letter-to-equalize-frequency/",
        difficulty = Difficulty.EASY
)
public class RemoveLetterToEqualizeFrequency
{
    public boolean equalFrequency(String word)
    {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : word.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        outer: for (char ch = 'a'; ch <= 'z'; ch++)
        {
            if (map.containsKey(ch))
            {
                int count = map.remove(ch) - 1;
                if (count > 0)
                {
                    map.put(ch, count);
                }

                Integer prev = null;
                for (int c: map.values())
                {
                    if (prev != null && prev != c)
                    {
                        map.put(ch, map.getOrDefault(ch, 0) + 1);
                        continue outer;
                    }

                    prev = c;
                }

                return true;
            }
        }

        return false;
    }
}
