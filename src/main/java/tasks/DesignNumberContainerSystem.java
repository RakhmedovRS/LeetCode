package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author Ruslan Rakhmedov
 * @created 7/25/2022
 * @Ruslan Rakhmedov$
 * @1.0$
 */
@LeetCode(
        id = 2349,
        name = "Design a Number Container System",
        url = "https://leetcode.com/problems/design-a-number-container-system/",
        difficulty = Difficulty.MEDIUM
)
public class DesignNumberContainerSystem
{
    class NumberContainers
    {
        Map<Integer, TreeSet<Integer>> map;
        Map<Integer, Integer> indexToValue;
        TreeSet<Integer> EMPTY;

        public NumberContainers()
        {
            map = new HashMap<>();
            indexToValue = new HashMap<>();
            EMPTY = new TreeSet<>();
        }

        public void change(int index, int number)
        {
            if (indexToValue.containsKey(index))
            {
                int oldNumber = indexToValue.get(index);
                indexToValue.put(index, number);

                if (number != oldNumber || !map.getOrDefault(oldNumber, EMPTY).contains(index))
                {
                    map.get(oldNumber).remove(index);
                }
            }
            else
            {
                indexToValue.put(index, number);
            }

            map.putIfAbsent(number, new TreeSet<>());
            map.get(number).add(index);
        }

        public int find(int number)
        {
            TreeSet<Integer> treeSet = map.getOrDefault(number, EMPTY);
            if (!treeSet.isEmpty())
            {
                return treeSet.first();
            }

            return -1;
        }
    }
}
