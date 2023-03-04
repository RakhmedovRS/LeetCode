package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 11/2/2022
 */
@LeetCode(
        id = 2456,
        name = "Most Popular Video Creator",
        url = "https://leetcode.com/problems/most-popular-video-creator/",
        difficulty = Difficulty.MEDIUM
)
public class MostPopularVideoCreator
{
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views)
    {
        Map<String, List<String>> creatorToID = new HashMap<>();
        Map<String, Long> creatorToViews = new HashMap<>();
        Map<String, Map<String, Long>> idToViews = new HashMap<>();

        long max = 0L;
        for (int i = 0; i < creators.length; i++)
        {
            idToViews.putIfAbsent(creators[i], new HashMap<>());
            Map<String, Long> map = idToViews.get(creators[i]);

            creatorToID.putIfAbsent(creators[i], new ArrayList<>());
            creatorToID.get(creators[i]).add(ids[i]);

            creatorToViews.put(creators[i], creatorToViews.getOrDefault(creators[i], 0L) + views[i]);
            max = Math.max(max, creatorToViews.get(creators[i]));

            map.put(ids[i], Math.max(map.getOrDefault(ids[i], 0L), views[i]));
            idToViews.put(creators[i], map);
        }

        List<List<String>> answer = new ArrayList<>();
        for (Map.Entry<String, Long> entry: creatorToViews.entrySet())
        {
            if (entry.getValue().equals(max))
            {
                Map<String, Long> map = idToViews.get(entry.getKey());

                creatorToID.get(entry.getKey()).sort((a, b) ->
                {
                    if (map.getOrDefault(a, 0L).equals(map.getOrDefault(b, 0L)))
                    {
                        return a.compareTo(b);
                    }

                    return Long.compare(map.getOrDefault(b, 0L), map.getOrDefault(a, 0L));
                });

                answer.add(Arrays.asList(entry.getKey(), creatorToID.get(entry.getKey()).get(0)));
            }
        }

        return answer;
    }
}
