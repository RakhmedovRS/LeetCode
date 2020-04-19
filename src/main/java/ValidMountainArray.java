import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 17-Mar-20
 */
@LeetCode(id = 941, name = "Valid Mountain Array", url = "https://leetcode.com/problems/valid-mountain-array/")
public class ValidMountainArray
{
	public boolean validMountainArray(int[] numbers)
	{
		if (numbers == null || numbers.length <= 2)
		{
			return false;
		}

		int max = Integer.MIN_VALUE;
		int maxIndex = 0;
		for (int i = 0; i < numbers.length; i++)
		{
			if (numbers[i] > max)
			{
				max = numbers[i];
				maxIndex = i;
			}
		}

		if (maxIndex == 0 || maxIndex == numbers.length - 1)
		{
			return false;
		}

		int prev = maxIndex;
		int next = maxIndex + 1;
		while (next < numbers.length)
		{
			if (numbers[prev] <= numbers[next])
			{
				return false;
			}
			prev++;
			next++;
		}

		prev = maxIndex;
		next = maxIndex - 1;
		while (next >= 0)
		{
			if (numbers[next] >= numbers[prev])
			{
				return false;
			}
			prev--;
			next--;
		}

		return true;
	}

	public static void main(String[] args)
	{
		System.out.println(new ValidMountainArray().validMountainArray(new int[]{0, 3, 2, 1}));
		System.out.println(new ValidMountainArray().validMountainArray(new int[]{3, 5, 5}));
	}
}
