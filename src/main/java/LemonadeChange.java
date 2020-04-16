import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 16-Apr-20
 */
@LeetCode(id = 860, name = "Lemonade Change", url = "https://leetcode.com/problems/lemonade-change/")
public class LemonadeChange
{
	public boolean lemonadeChange(int[] bills)
	{
		int fives = 0;
		int tens = 0;
		for (int bill : bills)
		{
			if (bill == 5)
			{
				fives++;
			}
			else if (bill == 10)
			{
				if (fives == 0)
				{
					return false;
				}
				fives--;
				tens++;
			}
			else
			{
				if (tens > 0 && fives > 0)
				{
					fives--;
					tens--;
				}
				else if (fives > 2)
				{
					fives -= 3;
				}
				else
				{
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args)
	{
		System.out.println(new LemonadeChange().lemonadeChange(new int[]{5, 5, 10, 10, 20}));
		System.out.println(new LemonadeChange().lemonadeChange(new int[]{5, 5, 5, 10, 20}));
		System.out.println(new LemonadeChange().lemonadeChange(new int[]{5, 5, 10}));
		System.out.println(new LemonadeChange().lemonadeChange(new int[]{10, 10}));
	}
}
