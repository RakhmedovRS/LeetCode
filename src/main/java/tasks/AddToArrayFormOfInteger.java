package tasks;

import common.LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 30-Mar-20
 */
@LeetCode(id = 989, name = "Add to Array-Form of Integer", url = "https://leetcode.com/problems/add-to-array-form-of-integer/")
public class AddToArrayFormOfInteger
{
	public List<Integer> addToArrayForm(int[] A, int k)
	{
		LinkedList<Integer> answer = new LinkedList<>();
		int pos;
		if (A == null || A.length == 0)
		{
			pos = -1;
		}
		else
		{
			pos = A.length - 1;
		}

		boolean hasRest = false;
		int result;
		int rest;
		while (hasRest || k > 0 || pos >= 0)
		{
			rest = k % 10;
			k /= 10;

			result = rest + (hasRest ? 1 : 0);

			if (pos >= 0)
			{
				result += A[pos--];
			}

			if (result >= 10)
			{
				answer.addFirst(result % 10);
				hasRest = true;
			}
			else
			{
				answer.addFirst(result);
				hasRest = false;
			}
		}

		return answer;
	}
}
