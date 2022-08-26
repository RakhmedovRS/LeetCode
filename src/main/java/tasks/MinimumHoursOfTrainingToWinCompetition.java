package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 8/26/2022
 * @Ruslan Rakhmedov$
 * @1.0$
 */
@LeetCode(
        id = 2383,
        name = "Minimum Hours of Training to Win a Competition",
        url = "https://leetcode.com/problems/minimum-hours-of-training-to-win-a-competition/",
        difficulty = Difficulty.EASY
)
public class MinimumHoursOfTrainingToWinCompetition
{
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience)
    {

        int add = 0;
        outer: while (true)
        {
            int exp = initialExperience;
            int en = initialEnergy;

            for (int i = 0; i < energy.length; i++)
            {
                if (en <= energy[i])
                {
                    initialEnergy++;
                    add++;
                    continue outer;
                }

                if (exp <= experience[i])
                {
                    initialExperience++;
                    add++;
                    continue outer;
                }

                en -= energy[i];
                exp += experience[i];
            }

            break;
        }

        return add;
    }
}
