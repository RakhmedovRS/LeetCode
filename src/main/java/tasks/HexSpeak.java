package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/18/2020
 */
@LeetCode(
		id = 1271,
		name = "Hexspeak",
		url = "https://leetcode.com/problems/hexspeak/",
		difficulty = Difficulty.EASY,
		premium = true
)
public class HexSpeak {
	public String toHexspeak(String num) {
		String hex = Long.toHexString(Long.parseLong(num));

		StringBuilder sb = new StringBuilder();
		for (char ch : hex.toCharArray()) {
			if (ch == '0') {
				sb.append('O');
			}
			else if (ch == '1') {
				sb.append('I');
			}
			else if (Character.isDigit(ch)) {
				return "ERROR";
			}
			else {
				sb.append(Character.toUpperCase(ch));
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new HexSpeak().toHexspeak("619879596177"));
		System.out.println(new HexSpeak().toHexspeak("257"));
		System.out.println(new HexSpeak().toHexspeak("3"));
	}
}
