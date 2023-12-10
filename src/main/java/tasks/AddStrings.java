package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12-Apr-20
 */
@LeetCode(
		id = 415,
		name = "Add Strings",
		url = "https://leetcode.com/problems/add-strings/",
		difficulty = Difficulty.EASY
)
public class AddStrings {
	public String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int posA = num1.length() - 1;
		int posB = num2.length() - 1;
		boolean reminder = false;
		while (posA < num1.length() || posB < num2.length() || reminder) {
			int num = 0;
			if (reminder) {
				num += 1;
				reminder = false;
			}

			if (posA >= 0) {
				num += num1.charAt(posA--) - '0';
			}

			if (posB >= 0) {
				num += num2.charAt(posB--) - '0';
			}


			if (num >= 10) {
				num %= 10;
				reminder = true;
			}

			sb.append(num);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new AddStrings().addStrings("0", "10"));
		System.out.println(new AddStrings().addStrings("10", "10"));
	}
}
