import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 07-May-20
 */
@LeetCode(id = 922, name = "Sort Array By Parity II", url = "https://leetcode.com/problems/sort-array-by-parity-ii/")
public class SortArrayByParityII
{
	public int[] sortArrayByParityII(int[] A)
	{
		if (A == null)
		{
			return new int[]{};
		}

		int[] result = new int[A.length];
		int even = 0;
		int odd = 1;
		for (int value : A)
		{
			if (value % 2 == 0)
			{
				result[even] = value;
				even += 2;
			}
			else
			{
				result[odd] = value;
				odd += 2;
			}
		}

		return result;
	}
}
