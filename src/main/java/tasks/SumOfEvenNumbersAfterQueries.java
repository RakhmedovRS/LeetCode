package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 02-Jun-20
 */
@LeetCode(id = 985, name = "Sum of Even Numbers After Queries", url = "https://leetcode.com/problems/sum-of-even-numbers-after-queries/")
public class SumOfEvenNumbersAfterQueries {
	public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
		int[] answer = new int[A.length];
		int even = 0;
		for (int num : A) {
			if (num % 2 == 0) {
				even += num;
			}
		}

		int pos = 0;
		for (int[] query : queries) {
			int index = query[1];
			int val = query[0];
			if ((A[index] + val) % 2 == 0) {
				if (A[index] % 2 == 0) {
					even += val;
				}
				else {
					even += A[index] + val;
				}
			}
			else {
				if (A[index] % 2 == 0) {
					even -= A[index];
				}
			}

			A[index] += val;
			answer[pos++] = even;
		}

		return answer;
	}
}
