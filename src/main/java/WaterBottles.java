import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 19-Jul-20
 */
@LeetCode(id = 1518, name = "Water Bottles", url = "https://leetcode.com/problems/water-bottles/")
public class WaterBottles
{
	public int numWaterBottles(int numBottles, int numExchange)
	{
		int sum = 0;
		int full = numBottles;
		int empty = 0;
		while (full > 0)
		{
			sum += full;
			empty += full;
			full = 0;
			full += empty / numExchange;
			empty -= full * numExchange;
		}

		return sum;
	}
}
