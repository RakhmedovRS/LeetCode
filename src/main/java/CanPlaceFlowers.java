import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 07-Sep-20
 */
@LeetCode(
	id = 605,
	name = "Can Place Flowers",
	url = "https://leetcode.com/problems/can-place-flowers/",
	difficulty = Difficulty.EASY
)
public class CanPlaceFlowers
{
	public boolean canPlaceFlowers(int[] flowerbed, int n)
	{
		for (int i = 0; i < flowerbed.length; i++)
		{
			if (canBeUsed(flowerbed, i))
			{
				n--;
				flowerbed[i] = 1;
			}
		}

		return n <= 0;
	}

	boolean canBeUsed(int[] flowerbed, int pos)
	{
		boolean prev = pos == 0 || flowerbed[pos - 1] == 0;
		boolean curr = flowerbed[pos] == 0;
		boolean next = pos == flowerbed.length - 1 || flowerbed[pos + 1] == 0;

		return prev && curr && next;
	}
}
