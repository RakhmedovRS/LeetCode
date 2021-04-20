package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 13-Mar-20
 */
@LeetCode(
        id = 242,
        name = "Valid Anagram",
        url = "https://leetcode.com/problems/valid-anagram/",
        difficulty = Difficulty.EASY
)
public class ValidAnagram
{
    public boolean isAnagram(String s, String t)
    {
        int[] table = new int[26];
        for (char ch : s.toCharArray())
        {
            table[ch - 'a']++;
        }

        for (char ch : t.toCharArray())
        {
            table[ch - 'a']--;
        }

        for (int value : table)
        {
            if (value != 0)
            {
                return false;
            }
        }

        return true;
    }
}
