package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 11-Sep-20
 */
@LeetCode(id = 1253, name = "Reconstruct a 2-Row Binary Matrix", url = "https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix/")
public class Reconstruct2RowBinaryMatrix
{
	public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum)
	{
		List<List<Integer>> answer = new ArrayList<>();
		answer.add(new ArrayList<>());
		answer.add(new ArrayList<>());
		for (int value : colsum)
		{
			if (value > upper + lower)
			{
				return Collections.emptyList();
			}

			if (value == 0)
			{
				answer.get(0).add(0);
				answer.get(1).add(0);
				continue;
			}

			if (upper > 0)
			{
				if (upper > value)
				{
					answer.get(0).add(value);
					upper -= value;
					value = 0;
				}
				else
				{
					answer.get(0).add(upper);
					value -= upper;
					upper = 0;
				}
			}
			else
			{
				answer.get(0).add(0);
			}

			if (value > 0)
			{
				answer.get(1).add(value);
				lower -= value;
			}
			else
			{
				answer.get(1).add(0);
			}
		}

		return (upper == 0 && lower == 0) ? answer : Collections.emptyList();
	}
}
