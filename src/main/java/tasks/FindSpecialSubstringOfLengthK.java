package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-02-15
 */
@LeetCode(
        id = 3456,
        name = "Find Special Substring of Length K",
        url = "https://leetcode.com/problems/find-special-substring-of-length-k/description/",
        difficulty = Difficulty.EASY
)
public class FindSpecialSubstringOfLengthK {
    public boolean hasSpecialSubstring(String s, int k) {
        char[][] chars = new char[26][k];
        for (char ch = 'a'; ch <= 'z'; ch++) {
            Arrays.fill(chars[ch - 'a'], ch);
        }

        for (char[] chars1 : chars) {
            String sub = String.valueOf(chars1);
            int ind = 0;
            while (s.indexOf(sub, ind) != -1) {
                ind = s.indexOf(sub, ind);
                if ((ind - 1 < 0 || (ind - 1 >= 0 && s.charAt(ind - 1) != sub.charAt(0)))
                        && (ind + k >= s.length() || (ind + k < s.length() && s.charAt(ind + k) != sub.charAt(0)))
                ) {
                    return true;
                }
                ind++;
            }
        }
        return false;
    }
}