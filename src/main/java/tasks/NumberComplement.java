package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 22-Mar-20
 */
@LeetCode(
		id = 476,
		name = "Number Complement",
		url = "https://leetcode.com/problems/number-complement/",
		difficulty = Difficulty.EASY
)
public class NumberComplement {
	public int findComplement(int num) {
		int i = 1;
		int mask = 1;
		while (mask <= num && i++ < 32) {
			num = num ^ mask;
			mask <<= 1;
		}
		return num;
	}

	public static void main(String[] args) {
		System.out.println(new NumberComplement().findComplement(5));
		System.out.println(new NumberComplement().findComplement(1));
	}
}
