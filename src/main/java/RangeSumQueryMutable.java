import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/19/2020
 */
@LeetCode(
	id = 307,
	name = "Range Sum Query - Mutable",
	url = "https://leetcode.com/problems/range-sum-query-mutable/",
	difficulty = Difficulty.MEDIUM
)
public class RangeSumQueryMutable
{
	class NumArray
	{
		int[] table;
		int[] origin;

		public NumArray(int[] nums)
		{
			origin = nums;
			table = new int[nums.length + 1];
			System.arraycopy(nums, 0, table, 1, nums.length);
			for (int i = 1; i < table.length; i++)
			{
				int j = i + leastSignificantBit(i);
				if (j < table.length)
				{
					table[j] += table[i];
				}
			}
		}

		public void update(int i, int val)
		{
			int prev = origin[i];
			origin[i] = val;
			int pos = i + 1;
			while (pos < table.length)
			{
				table[pos] -= prev;
				table[pos] += val;

				pos += leastSignificantBit(pos);
			}

		}

		public int sumRange(int i, int j)
		{
			int leftSum = 0;
			while (i > 0)
			{
				leftSum += table[i];
				i -= leastSignificantBit(i);
			}

			int rightSum = 0;
			j++;
			while (j > 0)
			{
				rightSum += table[j];
				j -= leastSignificantBit(j);
			}

			return rightSum - leftSum;
		}

		private int leastSignificantBit(int number)
		{
			int i = 0;
			for (; i < 31; i++)
			{
				if ((number & (1 << i)) != 0)
				{
					break;
				}
			}

			return 1 << i;
		}
	}

	public static void main(String[] args)
	{
		NumArray numArray = new RangeSumQueryMutable().new NumArray(new int[]{0, 9, 5, 7, 3});
		System.out.println(numArray.sumRange(4, 4)); //3
		System.out.println(numArray.sumRange(2, 4)); //15

		System.out.println();

		numArray = new RangeSumQueryMutable().new NumArray(new int[]{9, -8});
		numArray.update(0, 3);
		System.out.println(numArray.sumRange(1, 1)); //-8
		System.out.println(numArray.sumRange(0, 1)); //-5
		numArray.update(1, -3);
		System.out.println(numArray.sumRange(0, 1)); //0

		System.out.println();

		numArray = new RangeSumQueryMutable().new NumArray(new int[]{1, 3, 5});
		System.out.println(numArray.sumRange(0, 2));//9
		numArray.update(1, 2);
		System.out.println(numArray.sumRange(0, 2)); // 8
	}
}
