package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 12/4/2022
 * @$
 * @$
 */
@LeetCode(
        id = 2490,
        name = "Circular Sentence",
        url = "https://leetcode.com/problems/circular-sentence/",
        difficulty = Difficulty.EASY
)
public class CircularSentence
{
    public boolean isCircularSentence(String sentence)
    {
        String[] words = sentence.split(" ");
        if (words[0].charAt(0) != words[words.length - 1].charAt(words[words.length - 1].length() - 1))
        {
            return false;
        }

        for (int i = 1; i < words.length; i++)
        {
            if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0))
            {
                return false;
            }
        }

        return true;
    }
}
