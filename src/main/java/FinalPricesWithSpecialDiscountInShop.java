import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 14-Jun-20
 */
@LeetCode(id = 1475, name = "Final Prices With a Special Discount in a Shop", url = "https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/")
public class FinalPricesWithSpecialDiscountInShop
{
	public int[] finalPrices(int[] prices)
	{
		int[] answer = new int[prices.length];
		for (int i = 0; i < prices.length; i++)
		{
			int j = i + 1;
			while (j < prices.length && prices[j] > prices[i])
			{
				j++;
			}

			if (j == prices.length)
			{
				answer[i] = prices[i];
			}
			else
			{
				answer[i] = prices[i] - prices[j];
			}
		}

		answer[answer.length - 1] = prices[prices.length - 1];

		return answer;
	}
}
