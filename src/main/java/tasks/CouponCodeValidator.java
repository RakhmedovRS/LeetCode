package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-12-12
 */
@LeetCode(
        id = 3606,
        name = "Coupon Code Validator",
        url = "https://leetcode.com/problems/coupon-code-validator/description/",
        difficulty = Difficulty.EASY
)
public class CouponCodeValidator {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        Map<String, Integer> map = new HashMap<>();
        map.put("electronics", 0);
        map.put("grocery", 1);
        map.put("pharmacy", 2);
        map.put("restaurant", 3);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < code.length; i++) {
            if (isActive[i] && map.containsKey(businessLine[i].toLowerCase()) && validChars(code[i])) {
                ans.add(i);
            }
        }

        ans.sort((a, b) -> {
            String codeA = code[a];
            String codeB = code[b];
            if (map.get(businessLine[a]).equals(map.get(businessLine[b]))) {
                return codeA.compareTo(codeB);
            }

            return map.get(businessLine[a]) - map.get(businessLine[b]);
        });

        List<String> result = new ArrayList<>();
        for (int i : ans) {
            result.add(code[i]);
        }

        return result;
    }

    private boolean validChars(String input) {
        if (input.isEmpty()) {
            return false;
        }

        for (char ch : input.toCharArray()) {
            if (!Character.isLetterOrDigit(ch) && ch != '_') {
                return false;
            }
        }
        return true;
    }
}