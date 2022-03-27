package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 3/27/2022
 */
@LeetCode(
	id = 2217,
	name = "Find Palindrome With Fixed Length",
	url = "https://leetcode.com/problems/find-palindrome-with-fixed-length/",
	difficulty = Difficulty.MEDIUM
)
public class FindPalindromeWithFixedLength
{
	public long[] kthPalindrome(int[] queries, int intLength)
	{
		long[] answer = new long[queries.length];
		Arrays.fill(answer, -1);
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->
		{
			if (queries[a] == queries[b])
			{
				return a - b;
			}
			return queries[a] - queries[b];
		});

		for (int i = 0; i < queries.length; i++)
		{
			pq.add(i);
		}

		if (intLength == 1)
		{
			while (!pq.isEmpty() && queries[pq.peek()] <= 9)
			{
				int pos = pq.remove();
				answer[pos] = queries[pos];
			}

			return answer;
		}

		int startNumber = 1;
		for (int i = 0; i < intLength / 2 - (intLength % 2 == 0 ? 1 : 0); i++)
		{
			startNumber *= 10;
		}

		int currentNumber = startNumber;
		int iteration = 1;
		while (!pq.isEmpty() && currentNumber <= startNumber * 10 - 1)
		{

			if (currentNumber < queries[pq.peek()])
			{
				int diff = queries[pq.peek()] - currentNumber;
				iteration += diff;
				currentNumber += diff;
				continue;
			}

			if (iteration == queries[pq.peek()])
			{
				int index = pq.remove();

				answer[index] = createNumber(currentNumber, intLength);

				while (!pq.isEmpty() && queries[pq.peek()] == queries[index])
				{
					answer[pq.remove()] = answer[index];
				}
			}

			iteration++;
			currentNumber++;
		}

		return answer;
	}

	private long createNumber(int num, int intLength)
	{
		long result = num;
		if (intLength % 2 != 0)
		{
			num /= 10;
		}

		while (num > 0)
		{
			result *= 10;
			result += num % 10;
			num /= 10;
		}

		return result;
	}
}
