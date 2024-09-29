package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-09-28
 */
@LeetCode(
        id = 3304,
        name = "Find the K-th Character in String Game I",
        url = "https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/description/",
        difficulty = Difficulty.EASY
)
public class FindTheKthCharacterInStringGameI {
    public char kthCharacter(int k) {
        List<Character> list = new ArrayList<>();
        list.add('a');
        while (list.size() < k) {
            List<Character> list1 = new ArrayList<>(list);
            for (Character c : list) {
                char nextChar = (char) (((1 + c - 'a') % 26) + 'a');
                list1.add(nextChar);
            }
            list = list1;
        }
        return list.get(k - 1);
    }
}