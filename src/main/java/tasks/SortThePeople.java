package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 9/26/2022
 * @$
 * @$
 */
@LeetCode(
        id = 2418,
        name = "Sort the People",
        url = "https://leetcode.com/problems/sort-the-people/",
        difficulty = Difficulty.EASY
)
public class SortThePeople
{
    public String[] sortPeople(String[] names, int[] heights)
    {
        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        for (int i = 0; i < names.length; i++)
        {
            list.add(new java.util.AbstractMap.SimpleEntry<>(names[i], heights[i]));
        }

        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        String[] answer = new String[heights.length];
        for (int i = 0; i < names.length; i++)
        {
            answer[i] = list.get(i).getKey();
        }

        return answer;
    }
}
