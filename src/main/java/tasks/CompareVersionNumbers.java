package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 20-Jun-20
 */
@LeetCode(
		id = 165,
		name = "Compare Version Numbers",
		url = "https://leetcode.com/problems/compare-version-numbers/",
		difficulty = Difficulty.MEDIUM
)
public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		int v1;
		int v2;
		int v1Pos = 0;
		int v2Pos = 0;
		while (v1Pos < version1.length() || v2Pos < version2.length()) {
			v1 = 0;
			while (v1Pos < version1.length() && version1.charAt(v1Pos) != '.') {
				v1 *= 10;
				v1 += version1.charAt(v1Pos++) - '0';
			}
			v1Pos++;

			v2 = 0;
			while (v2Pos < version2.length() && version2.charAt(v2Pos) != '.') {
				v2 *= 10;
				v2 += version2.charAt(v2Pos++) - '0';
			}
			v2Pos++;

			if (v1 != v2) {
				return Integer.compare(v1, v2);
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		System.out.println(new CompareVersionNumbers().compareVersion("1.0", "1"));
		System.out.println(new CompareVersionNumbers().compareVersion("1", "1"));
		System.out.println(new CompareVersionNumbers().compareVersion("7.5.2.4", "7.5.3"));
	}
}
