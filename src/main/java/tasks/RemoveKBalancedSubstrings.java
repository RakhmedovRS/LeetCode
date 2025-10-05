package tasks;
import common.Difficulty;
import common.LeetCode;
import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-10-04
 */
@LeetCode(
id = 3703,
 name = "Remove K-Balanced Substrings",
 url = "https://leetcode.com/problems/remove-k-balanced-substrings/description/",
 difficulty = Difficulty.MEDIUM
)
public class RemoveKBalancedSubstrings {
    public String removeSubstring(String s, int k) {
        boolean[] deleted = new boolean[s.length()];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int left = 0; left < s.length(); left++) {
            if (s.charAt(left) == '(') {
                stack.addLast(left);
            } else {
                if (stack.size() < k) {
                    stack.clear();
                } else {
                    LinkedList<Integer> secondStack = new LinkedList<>();
                    int right = left;
                    for (; right < s.length() && right < left + k; right++) {
                        if (s.charAt(right) != ')') {
                            break;
                        }
                        secondStack.addLast(right);
                    }

                    if (secondStack.size() != k) {
                        stack.clear();
                        secondStack.clear();
                    } else {
                        while (!secondStack.isEmpty()){
                            deleted[stack.removeLast()] = true;
                            deleted[secondStack.removeLast()] = true;
                        }
                    }
                    left = right - 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if (!deleted[i]){
                sb.append(s.charAt(i));
            }
        }

        String result = sb.toString();
        if (s.equals(result)){
            return result;
        }

        return removeSubstring(result, k);
    }
}