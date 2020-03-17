import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 17-Mar-20
 */
@LeetCode(id = 941, name = "Valid Mountain Array", url = "https://leetcode.com/problems/valid-mountain-array/")
public class ValidMountainArray
{
	public boolean validMountainArray(int[] A)
	{
		if (A == null || A.length <= 2)
		{
			return false;
		}

		int current = 1;
		for (; current < A.length - 1; current++)
		{
			if (A[current] < A[current + 1] && A[current] > A[current - 1])
			{
				if (current + 1 == A.length - 1)
				{
					return false;
				}
				continue;
			}
			else if (A[current] == A[current + 1] || A[current] == A[current - 1])
			{
				return false;
			}
			else
			{
				break;
			}
		}

		for (int start = current; start > 0; start--)
		{
			if (A[start] <= A[start - 1])
			{
				return false;
			}
		}

		for (int start = current; start < A.length - 1; start++)
		{
			if (A[start] <= A[start + 1])
			{
				return false;
			}
		}

		return true;
	}
}
