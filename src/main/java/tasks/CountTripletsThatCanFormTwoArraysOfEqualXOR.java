package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 08-Sep-20
 */
@LeetCode(id = 1442, name = "Count Triplets That Can Form Two Arrays of Equal XOR", url = "https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/")
public class CountTripletsThatCanFormTwoArraysOfEqualXOR
{
	public int countTriplets(int[] A)
	{
		int n = A.length + 1;
		int res = 0;
		int[] prefix = new int[n];
		for (int i = 1; i < n; ++i)
		{
			prefix[i] = A[i - 1] ^ prefix[i - 1];
		}

		for (int i = 0; i < n; ++i)
		{
			for (int j = i + 1; j < n; ++j)
			{
				if (prefix[i] == prefix[j])
				{
					res += j - i - 1;
				}
			}
		}
		return res;
	}
}
