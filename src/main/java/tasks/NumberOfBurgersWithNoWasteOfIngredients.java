package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 12/21/2020
 */
@LeetCode(
		id = 1276,
		name = "Number of Burgers with No Waste of Ingredients",
		url = "https://leetcode.com/problems/number-of-burgers-with-no-waste-of-ingredients/",
		difficulty = Difficulty.MEDIUM
)
public class NumberOfBurgersWithNoWasteOfIngredients {
	public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
		if ((tomatoSlices == 0 && cheeseSlices != 0)
				|| (tomatoSlices != 0 && cheeseSlices == 0)
				|| tomatoSlices % 2 != 0) {
			return Collections.emptyList();
		}

		int low = 0;
		int high = cheeseSlices;
		int jumbo;
		int small;
		while (low <= cheeseSlices) {
			jumbo = low * 4;
			small = high * 2;
			if (jumbo + small == tomatoSlices) {
				return Arrays.asList(low, high);
			}

			low++;
			high--;
		}

		return Collections.emptyList();
	}
}
