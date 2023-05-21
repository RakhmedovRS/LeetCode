package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author Ruslan Rakhmedov
 * @created 5/20/2023
 */
@LeetCode(
        id = 2696,
        name = "Minimum String Length After Removing Substrings",
        url = "https://leetcode.com/problems/minimum-string-length-after-removing-substrings/",
        difficulty = Difficulty.EASY
)
public class MinimumStringLengthAfterRemovingSubstrings
{
    public int minLength(String s)
    {
        LinkedList<Character> characters = new LinkedList<>();
        boolean seen = true;
        for (char ch : s.toCharArray())
        {
            characters.addLast(ch);
        }

        while (seen && !characters.isEmpty())
        {
            LinkedList<Character> next = new LinkedList<>();
            while (!characters.isEmpty())
            {
                seen = false;
                char ch = characters.removeFirst();
                if (ch == 'B')
                {
                    if (!next.isEmpty() && next.getLast() == 'A')
                    {
                        seen = true;
                        next.removeLast();
                    }
                    else
                    {
                        next.addLast(ch);
                    }
                }
                else if (ch == 'D')
                {
                    if (!next.isEmpty() && next.getLast() == 'C')
                    {
                        seen = true;
                        next.removeLast();
                    }
                    else
                    {
                        next.addLast(ch);
                    }
                }
                else
                {
                    next.addLast(ch);
                }
            }

            characters = next;
        }

        return characters.size();
    }
}
