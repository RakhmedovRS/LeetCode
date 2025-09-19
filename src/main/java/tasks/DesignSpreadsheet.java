package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-09-18
 */
@LeetCode(
        id = 3484,
        name = "Design Spreadsheet",
        url = "https://leetcode.com/problems/design-spreadsheet/description/",
        difficulty = Difficulty.MEDIUM
)
public class DesignSpreadsheet {
    class Spreadsheet {
        Map<String, Integer> memo;

        public Spreadsheet(int rows) {
            memo = new HashMap<>();
        }

        public void setCell(String cell, int value) {
            memo.put(cell, value);
        }

        public void resetCell(String cell) {
            setCell(cell, 0);
        }

        public int getValue(String formula) {
            String[] parts = formula.split("=")[1].split("\\+");
            Integer leftPart = Character.isLetter(parts[0].charAt(0)) ? memo.getOrDefault(parts[0], 0) : Integer.parseInt(parts[0]);
            Integer rightPart = Character.isLetter(parts[1].charAt(0)) ? memo.getOrDefault(parts[1], 0) : Integer.parseInt(parts[1]);

            return leftPart + rightPart;
        }
    }
}