package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 19-Jun-20
 */
@LeetCode(id = 1441, name = "Build an Array With Stack Operations", url = "https://leetcode.com/problems/build-an-array-with-stack-operations/")
public class BuildArrayWithStackOperations
{
	public List<String> buildArray(int[] target, int n)
	{
		int currPos = 0;
		int currVal = 1;
		List<String> operations = new ArrayList<>();
		while (currPos < target.length)
		{
			while (target[currPos] > currVal++)
			{
				operations.add("Push");
				operations.add("Pop");
			}
			operations.add("Push");

			currPos++;
		}

		return operations;
	}
}
