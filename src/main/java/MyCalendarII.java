import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author RakhmedovRS
 * @version 1.0
 * @since 19.02.2021
 */
@LeetCode(
        id = 731,
        name = "My Calendar II",
        url = "https://leetcode.com/problems/my-calendar-ii/",
        difficulty = Difficulty.MEDIUM
)
public class MyCalendarII
{
    class MyCalendarTwo
    {
        List<int[]> events;
        TreeSet<Integer> ids;

        public MyCalendarTwo()
        {
            events = new ArrayList<>();
            ids = new TreeSet<>((a, b) ->
            {
                if (events.get(a)[0] == events.get(b)[0] && events.get(a)[1] == events.get(b)[1])
                {
                    return a - b;
                }
                else if (events.get(a)[0] == events.get(b)[0])
                {
                    return events.get(a)[1] - events.get(b)[1];
                }
                return events.get(a)[0] - events.get(b)[0];
            });
        }

        public boolean book(int start, int end)
        {
            boolean validAddition = true;
            events.add(new int[]{start, end});
            ids.add(events.size() - 1);

            int balance = 0;
            int[] current;
            TreeMap<Integer, Integer> ends = new TreeMap<>();
            for (int index : ids)
            {
                current = events.get(index);
                while (!ends.isEmpty() && ends.firstKey() <= current[0])
                {
                    balance -= ends.remove(ends.firstKey());
                }

                balance++;
                if (balance > 3)
                {
                    validAddition = false;
                    break;
                }

                ends.put(current[1], ends.getOrDefault(current[1], 0) + 1);
            }

            if (!validAddition)
            {
                ids.remove(events.size() - 1);
                events.remove(events.size() - 1);
            }

            return validAddition;
        }
    }
}
