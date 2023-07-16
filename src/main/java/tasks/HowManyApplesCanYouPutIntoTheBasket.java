package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 12/11/2020
 */
@LeetCode(
		id = 1196,
		name = "How Many Apples Can You Put into the Basket",
		url = "https://leetcode.com/problems/how-many-apples-can-you-put-into-the-basket/",
		difficulty = Difficulty.EASY,
		premium = true
)
public class HowManyApplesCanYouPutIntoTheBasket
{
	public int maxNumberOfApples(int[] arr)
	{
		Arrays.sort(arr);
		int count = 0;
		int sum = 5000;
		for (int i = 0; i < arr.length && sum > 0; i++)
		{
			sum -= arr[i];
			if (sum >= 0)
			{
				count++;
			}
		}
		return count;
	}
}
