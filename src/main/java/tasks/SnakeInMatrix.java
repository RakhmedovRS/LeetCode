package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-10-03
 */
@LeetCode(
        id = 3248,
        name = "Snake in Matrix",
        url = "https://leetcode.com/problems/snake-in-matrix/description/",
        difficulty = Difficulty.EASY
)
public class SnakeInMatrix {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int position = 0;
        for (String command : commands) {
            if ("UP".equals(command)) {
                position -= n;
            } else if ("DOWN".equals(command)) {
                position += n;
            } else if ("LEFT".equals(command)) {
                position--;
            } else if ("RIGHT".equals(command)) {
                position++;
            }
        }
        return position;
    }
}