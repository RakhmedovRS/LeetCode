package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-11-03
 */
@LeetCode(
        id = 3163,
        name = "String Compression III",
        url = "https://leetcode.com/problems/string-compression-iii/description/",
        difficulty = Difficulty.MEDIUM
)
public class StringCompressionIII {
    public String compressedString(String word) {
        char[] chars = word.toCharArray();
        char prev = chars[0];
        int count = 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != prev || count == 9) {
                sb.append(count);
                sb.append(prev);
                prev = chars[i];
                count = 1;
            } else {
                count++;
            }
        }

        sb.append(count);
        sb.append(prev);

        return sb.toString();
    }
}