package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 3/6/2022
 */
@LeetCode(
		id = 2194,
		name = "Cells in a Range on an Excel Sheet",
		url = "https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet/",
		difficulty = Difficulty.EASY
)
public class CellsInRangeOnExcelSheet {
	public List<String> cellsInRange(String s) {
		List<String> answer = new ArrayList<>();
		String[] parts = s.split(":");
		for (char ch = parts[0].charAt(0); ch <= parts[1].charAt(0); ch++) {
			for (char ch2 = parts[0].charAt(1); ch2 <= parts[1].charAt(1); ch2++) {
				answer.add("" + ch + ch2);
			}
		}

		return answer;
	}
}
