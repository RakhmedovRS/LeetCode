package contest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * @author RakhmedovRS
 * @created 9/27/2020
 */
public class Contest
{

	public int maxProfit(int[] prices)
	{
		int min = prices[0];
		int max = 0;
		for (int i = 1; i < prices.length; i++)
		{
			max = Math.max(max, prices[i] - min);
			min = Math.min(min, prices[i]);
		}

		return max;
	}

	public static void main(String[] args) throws Exception
	{
		Contest clazz = new Contest();
		System.out.println(clazz.maxProfit(new int[]{7, 6, 4, 3, 1}));
	}

	private static String readBigTestCase() throws IOException
	{
		try (BufferedReader br = new BufferedReader(new FileReader(Thread.currentThread().getContextClassLoader().getResource("TestCase.txt").getFile())))
		{
			return br.lines().collect(Collectors.joining());
		}
	}
}
