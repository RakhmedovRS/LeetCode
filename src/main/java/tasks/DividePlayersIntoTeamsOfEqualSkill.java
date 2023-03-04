package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 12/10/2022
 */
@LeetCode(
        id = 2491,
        name = "Divide Players Into Teams of Equal Skill",
        url = "https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/",
        difficulty = Difficulty.MEDIUM
)
public class DividePlayersIntoTeamsOfEqualSkill
{
    public long dividePlayers(int[] skill)
    {
        Arrays.sort(skill);
        long res = 0;

        int[] sums = new int[skill.length / 2];
        long[] mult = new long[skill.length / 2];
        int pos = 0;
        for (int i = 0; i < skill.length / 2; i++)
        {
            pos %= sums.length;
            mult[pos] += (long) skill[i] * skill[skill.length - i - 1];
            sums[pos++] += skill[i] + skill[skill.length - i - 1];
        }

        res += mult[0];
        for (int i = 1; i < sums.length; i++)
        {
            if (sums[i - 1] != sums[i])
            {
                return -1;
            }

            res += mult[i];
        }

        return res;
    }
}
