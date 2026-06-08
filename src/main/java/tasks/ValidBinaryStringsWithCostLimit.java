package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-06-07
 */
@LeetCode(
        id = 3955,
        name = "Valid Binary Strings With Cost Limit",
        url = "https://leetcode.com/problems/valid-binary-strings-with-cost-limit/description/",
        difficulty = Difficulty.MEDIUM
)
public class ValidBinaryStringsWithCostLimit {
    class BinaryString {
        private String s;
        private int bits;

        public BinaryString(String s, int bits) {
            this.s = s;
            this.bits = bits;
        }
    }

    public List<String> generateValidStrings(int n, int k) {
        List<BinaryString> binaryStrings = new ArrayList<>();
        binaryStrings.add(new BinaryString("", 0));

        for (int i = 1; i <= n; i++) {
            List<BinaryString> next = new ArrayList<>();
            for (BinaryString b : binaryStrings) {
                next.add(new BinaryString(b.s + "0", b.bits));

                if ((b.s.isEmpty() || b.s.charAt(b.s.length() - 1) == '0')) {
                    next.add(new BinaryString(b.s + "1", b.bits + 1));
                }
            }

            binaryStrings = next;
        }

        return new ArrayList<>(binaryStrings.stream().filter(b -> {
                    int total = 0;
                    for (int i = 0; i < b.s.length(); i++) {
                        if (b.s.charAt(i) == '1') {
                            total += i;
                        }
                    }
                    return total <= k;
                }).map(b -> b.s)
                .collect(Collectors.toSet()));
    }
}