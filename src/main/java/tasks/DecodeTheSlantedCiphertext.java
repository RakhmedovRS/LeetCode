package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/14/2021
 */
@LeetCode(
		id = 2075,
		name = "Decode the Slanted Ciphertext",
		url = "https://leetcode.com/problems/decode-the-slanted-ciphertext/",
		difficulty = Difficulty.MEDIUM
)
public class DecodeTheSlantedCiphertext {
	public String decodeCiphertext(String encodedText, int rows) {
		int columns = encodedText.length() / rows;
		char[][] matrix = new char[rows][columns];
		int pos = 0;
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				matrix[row][column] = (pos < encodedText.length() ? encodedText.charAt(pos++) : ' ');
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int column = 0; column < columns; column++) {
			for (int r = 0, c = column; r < rows && c < columns; r++, c++) {
				sb.append(matrix[r][c]);
			}
		}
		while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
			sb.deleteCharAt(sb.length() - 1);
		}

		return sb.toString();
	}
}
