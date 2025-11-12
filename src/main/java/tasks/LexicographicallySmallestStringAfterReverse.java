package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-10-25
 */
@LeetCode(
        id = 3722,
        name = "Lexicographically Smallest String After Reverse",
        url = "https://leetcode.com/problems/lexicographically-smallest-string-after-reverse/description/",
        difficulty = Difficulty.MEDIUM
)
public class LexicographicallySmallestStringAfterReverse {
    public String lexSmallest(String s) {
        String ans = null;
        for (int i = 0; i < s.length(); i++) {
            String frontReverse = reverse(s, 0, i);
            String tailReverse = reverse(s, i + 1, s.length() - 1);
            if (ans == null) {
                ans = frontReverse;
            } else {
                if (frontReverse.compareTo(ans) < 0) {
                    ans = frontReverse;
                }
            }

            if (tailReverse.compareTo(ans) < 0) {
                ans = tailReverse;
            }
        }
        return ans;
    }

    private String reverse(String s, int left, int right) {
        char[] chars = s.toCharArray();
        for (; left <= right; left++, right--) {
            char ch = chars[left];
            chars[left] = chars[right];
            chars[right] = ch;
        }
        return String.valueOf(chars);
    }
}