package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 8/9/2022
 * @Ruslan Rakhmedov$
 * @1.0$
 */
@LeetCode(
        id = 2365,
        name = "Task Scheduler II",
        url = "https://leetcode.com/problems/task-scheduler-ii/",
        difficulty = Difficulty.MEDIUM
)
public class TaskSchedulerII
{
    public long taskSchedulerII(int[] tasks, int space)
    {
        Map<Integer, Long> map = new HashMap<>();
        long currentDay = 1;
        for (int i = 0; i < tasks.length; i++)
        {
            int task = tasks[i];
            if (map.getOrDefault(task, -1L) < currentDay)
            {
                map.put(task, currentDay + space + 1);
                if (i + 1 < tasks.length)
                {
                    currentDay++;
                }
            }
            else
            {
                currentDay = Math.max(currentDay, map.remove(task));
                map.put(task, currentDay + space + 1);
                if (i + 1 < tasks.length)
                {
                    currentDay++;
                }
            }
        }

        return currentDay;
    }
}
