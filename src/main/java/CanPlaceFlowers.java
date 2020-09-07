import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 07-Sep-20
 */
@LeetCode(id = 605, name = "Can Place Flowers", url = "https://leetcode.com/problems/can-place-flowers/")
public class CanPlaceFlowers
{
	public boolean canPlaceFlowers(int[] flowerbed, int n)
	{
		for (int i = 0; i < flowerbed.length; i++)
		{
			if (n == 0)
			{
				break;
			}

			if (flowerbed[i] == 0 && canBePlaced(flowerbed, i))
			{
				flowerbed[i] = 1;
				n--;
			}
		}

		return n == 0;
	}

	private boolean canBePlaced(int[] flowerbed, int index)
	{
		if (index - 1 >= 0 && flowerbed[index - 1] == 1)
		{
			return false;
		}

		if (index + 1 < flowerbed.length && flowerbed[index + 1] == 1)
		{
			return false;
		}

		return true;
	}
}
