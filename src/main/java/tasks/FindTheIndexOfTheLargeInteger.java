package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/22/2020
 */
@LeetCode(
	id = 1533,
	name = "Find the Index of the Large Integer",
	url = "https://leetcode.com/problems/find-the-index-of-the-large-integer/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class FindTheIndexOfTheLargeInteger
{
	interface ArrayReader
	{
		// Compares the sum of arr[l..r] with the sum of arr[x..y]
		// return 1 if sum(arr[l..r]) > sum(arr[x..y])
		// return 0 if sum(arr[l..r]) == sum(arr[x..y])
		// return -1 if sum(arr[l..r]) < sum(arr[x..y])
		int compareSub(int l, int r, int x, int y);

		// Returns the length of the array
		int length();
	}

	class ArrayReaderImpl implements ArrayReader
	{
		int[] array;

		public ArrayReaderImpl(int[] array)
		{
			this.array = array;
		}

		@Override
		public int compareSub(int l, int r, int x, int y)
		{
			int leftSum = 0;
			int rightSum = 0;

			while (l <= r)
			{
				leftSum += array[l++];
			}

			while (x <= y)
			{
				rightSum += array[x++];
			}

			return Integer.compare(leftSum, rightSum);
		}

		@Override
		public int length()
		{
			return array.length;
		}
	}

	public int getIndex(ArrayReader reader)
	{
		int left = 0;
		int middle;
		int right = reader.length() - 1;
		int result;
		while (left < right)
		{
			middle = (left + right) / 2;
			if ((right - left) % 2 == 0)
			{
				result = reader.compareSub(left, middle - 1, middle + 1, right);
				if (result == 0)
				{
					return middle;
				}
				else if (result < 0)
				{
					left = middle + 1;
				}
				else
				{
					right = middle - 1;
				}
			}
			else
			{
				if (reader.compareSub(left, middle, middle + 1, right) == 1)
				{
					right = middle;
				}
				else
				{
					left = middle + 1;
				}
			}
		}

		return left;
	}

	public static void main(String[] args)
	{
		FindTheIndexOfTheLargeInteger clazz = new FindTheIndexOfTheLargeInteger();

		System.out.println(clazz.getIndex(clazz.new ArrayReaderImpl(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 17})));
		System.out.println(clazz.getIndex(clazz.new ArrayReaderImpl(new int[]{6, 6, 7})));
		System.out.println(clazz.getIndex(clazz.new ArrayReaderImpl(new int[]{6, 6, 12})));
		System.out.println(clazz.getIndex(clazz.new ArrayReaderImpl(new int[]{7, 7, 7, 7, 10, 7, 7, 7})));
	}
}
