package tasks;

import common.Difficulty;
import common.LeetCode;

@LeetCode(
        id = 2710,
        name = "Remove Trailing Zeros From a String",
        url = "https://leetcode.com/problems/remove-trailing-zeros-from-a-string/",
        difficulty = Difficulty.EASY
)
public class RemoveTrailingZerosFromString
{
    public String removeTrailingZeros(String num) {
        int left = 0;
        int right = num.length() - 1;
        while (left < right && (num.charAt(left) == '0' || num.charAt(right) == '0'))
        {
            if (num.charAt(left) == '0'){
                left++;
            }

            if (left < right && num.charAt(right) == '0'){
                right--;
            }
        }

        return num.substring(left, right + 1);
    }
}
