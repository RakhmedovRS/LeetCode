import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/27/2020
 */
@LeetCode(id = 686, name = "Repeated String Match", url = "https://leetcode.com/problems/repeated-string-match/")
public class RepeatedStringMatch
{
	public int repeatedStringMatch(String A, String B)
	{
		if (A == null || A.isEmpty())
		{
			return B == null ? 0 : B.length() == 0 ? 0 : -1;
		}

		if (B == null || B.isEmpty())
		{
			return 0;
		}

		int count = 1;
		StringBuilder temp = new StringBuilder(A);
		if (canCreate(A, B))
		{
			while (!temp.toString().contains(B))
			{
				temp.append(A);
				count++;
			}
			return count;
		}

		return -1;
	}

	private boolean canCreate(String A, String B)
	{
		int j;
		for (int i = 0; i < A.length(); i++)
		{
			j = i;
			for (int pos = 0; pos < B.length(); pos++)
			{
				if (A.charAt(j % A.length()) != B.charAt(pos))
				{
					break;
				}

				if (pos + 1 == B.length())
				{
					return true;
				}
				j++;
			}
		}

		return false;
	}
}
