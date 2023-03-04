package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 10/23/2022
 */
@LeetCode(
        id = 2446,
        name = "Determine if Two Events Have Conflict",
        url = "https://leetcode.com/problems/determine-if-two-events-have-conflict/",
        difficulty = Difficulty.EASY
)
public class DetermineIfTwoEventsHaveConflict
{
    public boolean haveConflict(String[] event1, String[] event2)
    {
        boolean[] seen = new boolean[24 * 60 * 60 + 1];

        String[] ev1S = event1[0].split(":");
        String[] ev1E = event1[1].split(":");

        int ev1s = Integer.parseInt(ev1S[0]) * 60 + Integer.parseInt(ev1S[1]);
        int ev1e = Integer.parseInt(ev1E[0]) * 60 + Integer.parseInt(ev1E[1]);

        for (int i = ev1s; i <= ev1e; i++)
        {
            seen[i] = true;
        }

        String[] ev2S = event2[0].split(":");
        String[] ev2E = event2[1].split(":");

        int ev2s = Integer.parseInt(ev2S[0]) * 60 + Integer.parseInt(ev2S[1]);
        int ev2e = Integer.parseInt(ev2E[0]) * 60 + Integer.parseInt(ev2E[1]);

        for (int i = ev2s; i <= ev2e; i++)
        {
            if (seen[i])
            {
                return true;
            }
        }

        return false;
    }
}
