package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 5/13/2023
 */
@LeetCode(
		id = 2678,
		name = "Number of Senior Citizens",
		url = "https://leetcode.com/problems/number-of-senior-citizens/",
		difficulty = Difficulty.EASY
)
public class NumberOfSeniorCitizens {
	public int countSeniors(String[] details) {
		int count = 0;
		for (String d : details) {
			if (Integer.parseInt(d.substring(11, 13)) > 60) {
				count++;
			}
		}
		return count;
	}
}
