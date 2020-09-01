import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 14-Aug-20
 */
@LeetCode(id = 949, name = "Largest Time for Given Digits", url = "https://leetcode.com/problems/largest-time-for-given-digits/")
public class LargestTimeForGivenDigits
{
	public String largestTimeFromDigits(int[] A)
	{
		int[] numbers = new int[10];
		for (int num : A)
		{
			numbers[num]++;
		}

		for (int h1 = 2; h1 >= 0; h1--)
		{
			if (numbers[h1] == 0)
			{
				continue;
			}

			numbers[h1]--;

			for (int h2 = h1 == 2 ? 3 : 9; h2 >= 0; h2--)
			{
				if (numbers[h2] == 0)
				{
					continue;
				}

				numbers[h2]--;

				for (int m1 = 5; m1 >= 0; m1--)
				{
					if (numbers[m1] == 0)
					{
						continue;
					}

					numbers[m1]--;

					for (int m2 = 9; m2 >= 0; m2--)
					{
						if (numbers[m2] == 0)
						{
							continue;
						}

						return "" + h1 + h2 + ":" + m1 + m2;
					}

					numbers[m1]++;
				}

				numbers[h2]++;
			}

			numbers[h1]++;
		}

		return "";
	}
}
