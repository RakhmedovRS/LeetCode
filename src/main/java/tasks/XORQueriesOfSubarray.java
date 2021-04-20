package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10-Aug-20
 */
@LeetCode(id = 1310, name = "XOR Queries of a Subarray", url = "https://leetcode.com/problems/xor-queries-of-a-subarray/")
public class XORQueriesOfSubarray
{
	public int[] xorQueries(int[] arr, int[][] queries)
	{
		for (int i = 1; i < arr.length; i++)
		{
			arr[i] ^= arr[i - 1];
		}

		int[] answer = new int[queries.length];
		for (int pos = 0; pos < answer.length; pos++)
		{
			int[] query = queries[pos];
			answer[pos] = query[0] > 0 ? arr[query[0] - 1] ^ arr[query[1]] : arr[query[1]];
		}
		return answer;
	}
}
