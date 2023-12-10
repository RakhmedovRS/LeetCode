package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 26-Mar-20
 */
@LeetCode(
		id = 118,
		name = "Pascal's Triangle",
		url = "https://leetcode.com/problems/pascals-triangle/",
		difficulty = Difficulty.EASY
)
public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> lists = new ArrayList<>();
		if (numRows >= 1) {
			lists.add(Arrays.asList(1));
		}

		if (numRows >= 2) {
			lists.add(Arrays.asList(1, 1));
		}

		if (numRows >= 3) {
			for (int i = 2; i < numRows; i++) {
				lists.add(new ArrayList<>());
				lists.get(i).add(1);
				for (int j = 1; j < i; j++) {
					lists.get(i).add(lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
				}

				lists.get(i).add(1);
			}
		}

		return lists;
	}

	public static void main(String[] args) {
		new PascalTriangle().generate(5).forEach(System.out::println);
	}
}
