package tasks;

import common.LeetCode;

import java.util.Stack;

/**
 * @author RakhmedovRS
 * @created 19-May-20
 */
@LeetCode(id = 901, name = "Online Stock Span", url = "https://leetcode.com/problems/online-stock-span/")
public class OnlineStockSpan
{
	class StockSpanner
	{

		Stack<Integer> prices, weights;

		public StockSpanner()
		{
			prices = new Stack();
			weights = new Stack();
		}

		public int next(int price)
		{
			int w = 1;
			while (!prices.isEmpty() && prices.peek() <= price)
			{
				prices.pop();
				w += weights.pop();
			}

			prices.push(price);
			weights.push(w);
			return w;
		}
	}
}
