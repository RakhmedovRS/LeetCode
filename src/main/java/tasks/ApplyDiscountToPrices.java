package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 6/12/2022
 */
@LeetCode(
		id = 2288,
		name = "Apply Discount to Prices",
		url = "https://leetcode.com/problems/apply-discount-to-prices/",
		difficulty = Difficulty.MEDIUM
)
public class ApplyDiscountToPrices {
	public String discountPrices(String sentence, int discount) {
		String[] words = sentence.split(" ");
		List<String> answer = new ArrayList<>();
		outer:
		for (String word : words) {
			if (word.length() > 1 && word.charAt(0) == '$') {
				for (int i = 1; i < word.length(); i++) {
					if (!Character.isDigit(word.charAt(i))) {
						answer.add(word);
						continue outer;
					}
				}

				if (discount == 100) {
					answer.add("$0.00");
				}
				else {
					answer.add("$" + String.format("%.2f", Double.parseDouble(word.substring(1)) - ((Double.parseDouble(word.substring(1)) / 100) * discount)));
				}
			}
			else {
				answer.add(word);
			}
		}

		return String.join(" ", answer);
	}
}
