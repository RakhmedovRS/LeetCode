package tasks;

import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 11/8/2020
 */
@LeetCode(id = 1404, name = "Number of Steps to Reduce a Number in Binary Representation to One", url = "https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/")
public class NumberOfStepsToReduceNumberInBinaryRepresentationToOne
{
	public int numSteps(String s)
	{
		int steps = 0;
		LinkedList<Boolean> binaryRepresentation = new LinkedList<>();
		for (char ch : s.toCharArray())
		{
			binaryRepresentation.addFirst(ch == '1');
		}

		while (binaryRepresentation.size() != 1)
		{
			if (!binaryRepresentation.getFirst())
			{
				binaryRepresentation.removeFirst();
			}
			else
			{
				LinkedList<Boolean> list = new LinkedList<>();
				boolean hasRest = true;
				for (boolean bit : binaryRepresentation)
				{
					if (bit && hasRest)
					{
						list.add(false);
					}
					else if (bit || hasRest)
					{
						list.add(true);
						hasRest = false;
					}
					else
					{
						list.add(false);
					}
				}

				if (hasRest)
				{
					list.add(true);
				}
				binaryRepresentation = list;
			}
			steps++;
		}

		return steps;
	}

	public static void main(String[] args)
	{
		System.out.println(new NumberOfStepsToReduceNumberInBinaryRepresentationToOne().numSteps("1101"));
		System.out.println(new NumberOfStepsToReduceNumberInBinaryRepresentationToOne().numSteps("10"));
	}
}
