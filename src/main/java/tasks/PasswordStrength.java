package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-05-25
 */
@LeetCode(
        id = 3941,
        name = "Password Strength",
        url = "https://leetcode.com/problems/password-strength/description/",
        difficulty = Difficulty.MEDIUM
)
public class PasswordStrength {
    public int passwordStrength(String password) {
        Set<Character> lower = new HashSet<>();
        Set<Character> upper = new HashSet<>();
        Set<Integer> digits = new HashSet<>();
        Set<Character> special = new HashSet<>();

        int ans = 0;
        for (char ch : password.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                if (Character.isUpperCase(ch)) {
                    if (upper.add(ch)) {
                        ans += 2;
                    }
                } else if (Character.isLowerCase(ch)) {
                    if (lower.add(ch)) {
                        ans++;
                    }
                }
            } else if (Character.isDigit(ch)) {
                if (digits.add(ch - '0')) {
                    ans += 3;
                }
            } else {
                if (special.add(ch)) {
                    ans += 5;
                }
            }
        }
        return ans;
    }
}