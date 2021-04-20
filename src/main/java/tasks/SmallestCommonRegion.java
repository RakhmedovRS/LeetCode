package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @version 1.0
 * @since 20.02.2021
 */
@LeetCode(
        id = 1257,
        name = "Smallest Common Region",
        url = "https://leetcode.com/problems/smallest-common-region/",
        difficulty = Difficulty.MEDIUM,
        premium = true
)
public class SmallestCommonRegion
{

    public String findSmallestRegion(List<List<String>> regions, String region1, String region2)
    {
        Map<String, String> parents = new HashMap<>();
        for (List<String> regionsList : regions)
        {
            String parentRegion = regionsList.get(0);
            for (int i = 1; i < regionsList.size(); i++)
            {
                String region = regionsList.get(i);
                parents.put(region, parentRegion);
            }
        }

        Set<String> visited = new HashSet<>();
        while (region1 != null)
        {
            visited.add(region1);
            region1 = parents.get(region1);
        }

        while (region2 != null)
        {
            if (!visited.add(region2))
            {
                return region2;
            }

            region2 = parents.get(region2);
        }

        return "";
    }
}
