package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 15-Aug-20
 */
@LeetCode(
		id = 1247,
		name = "Minimum Swaps to Make Strings Equal",
		url = "https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumSwapsToMakeStringsEqual {
	public int minimumSwap(String s1, String s2) {
		int xy = 0;
		int yx = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y') {
				xy++;
			}
			else if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x') {
				yx++;
			}
		}

		if ((xy % 2 == 0 && yx % 2 != 0) || (yx % 2 == 0 && xy % 2 != 0)) {
			return -1;
		}

		return xy / 2 + yx / 2 + xy % 2 + yx % 2;
	}

	public static void main(String[] args) {
		System.out.println(new MinimumSwapsToMakeStringsEqual().minimumSwap("xy", "yx"));
		System.out.println(new MinimumSwapsToMakeStringsEqual().minimumSwap("xxyyxyxyxx", "xyyxyxxxyx"));
		System.out.println(new MinimumSwapsToMakeStringsEqual().minimumSwap("xx", "yy"));
	}
}
