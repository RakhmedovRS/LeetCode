package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 24-Jul-20
 */
@LeetCode(
		id = 875,
		name = "Koko Eating Bananas",
		url = "https://leetcode.com/problems/koko-eating-bananas/",
		difficulty = Difficulty.MEDIUM
)
public class KokoEatingBananas {
	public int minEatingSpeed(int[] piles, int H) {
		int min = 1;
		int max = Integer.MIN_VALUE;
		for (int num : piles) {
			max = Math.max(max, num);
		}

		int middle;
		while (min < max) {
			middle = (min + max) / 2;
			if (check(piles, H, middle)) {
				max = middle;
			}
			else {
				min = middle + 1;
			}
		}

		return max;
	}

	private boolean check(int[] piles, int h, int size) {
		int needHours = 0;
		for (int pile : piles) {
			needHours += pile / size;
			if (pile % size != 0) {
				needHours++;
			}
		}

		return needHours <= h;
	}
}
