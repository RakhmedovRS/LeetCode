package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/6/2021
 */
@LeetCode(
		id = 1256,
		name = "Encode Number",
		url = "https://leetcode.com/problems/encode-number/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class EncodeNumber {
	public String encode(int num) {
		return Integer.toBinaryString(num + 1).substring(1);
	}
}
