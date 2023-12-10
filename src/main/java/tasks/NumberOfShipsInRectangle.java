package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @version 1.0
 * @since 19.02.2021
 */
@LeetCode(
		id = 1274,
		name = "Number of Ships in a Rectangle",
		url = "https://leetcode.com/problems/number-of-ships-in-a-rectangle/",
		difficulty = Difficulty.HARD,
		premium = true
)
public class NumberOfShipsInRectangle {
	interface Sea {
		boolean hasShips(int[] topRight, int[] bottomLeft);
	}

	public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
		if (!sea.hasShips(topRight, bottomLeft)) {
			return 0;
		}

		if (topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]) {
			return 1;
		}

		int xMiddle0 = (topRight[0] + bottomLeft[0]) / 2;
		int yMiddle0 = (topRight[1] + bottomLeft[1]) / 2;
		int xMiddle1 = xMiddle0 + 1;
		int yMiddle1 = yMiddle0 + 1;

		return countShips(sea, new int[]{xMiddle0, yMiddle0}, bottomLeft)
				+ countShips(sea, topRight, new int[]{xMiddle1, yMiddle1})
				+ countShips(sea, new int[]{xMiddle0, topRight[1]}, new int[]{bottomLeft[0], yMiddle1})
				+ countShips(sea, new int[]{topRight[0], yMiddle0}, new int[]{xMiddle1, bottomLeft[1]});
	}
}
