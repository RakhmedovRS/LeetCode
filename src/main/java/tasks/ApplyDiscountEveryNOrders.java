package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 20-Jul-20
 */
@LeetCode(
		id = 1357,
		name = "Apply Discount Every n Orders",
		url = "https://leetcode.com/problems/apply-discount-every-n-orders/",
		difficulty = Difficulty.MEDIUM
)
public class ApplyDiscountEveryNOrders {
	class Cashier {
		int currentCustomer;
		int happyCustomer;
		double discount;
		Map<Integer, Integer> productToPrice;

		public Cashier(int n, int discount, int[] products, int[] prices) {
			currentCustomer = 0;
			happyCustomer = n;
			this.discount = discount / 100D;
			productToPrice = new HashMap<>();
			for (int i = 0; i < products.length; i++) {
				productToPrice.put(products[i], prices[i]);
			}
		}

		public double getBill(int[] product, int[] amount) {
			double bill = 0;
			for (int pos = 0; pos < product.length; pos++) {
				bill += productToPrice.get(product[pos]) * amount[pos];
			}

			currentCustomer++;
			if (currentCustomer == happyCustomer) {
				bill -= bill * discount;
				currentCustomer = 0;
			}
			return bill;
		}
	}
}
