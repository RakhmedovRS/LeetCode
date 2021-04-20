package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 02-Jun-20
 */
@LeetCode(id = 1424, name = "Diagonal Traverse II", url = "https://leetcode.com/problems/diagonal-traverse-ii/")
public class DiagonalTraverseII
{
	public int[] findDiagonalOrder(List<List<Integer>> nums)
	{
		List<Integer> temp = new ArrayList<>();
		LinkedList<int[]> positions = new LinkedList<>();
		int row = 0;
		while (row < nums.size())
		{
			int size = positions.size();
			while (size-- > 0)
			{
				int[] position = positions.removeLast();
				if (position[0] < nums.get(position[1]).size())
				{
					temp.add(nums.get(position[1]).get(position[0]++));
					positions.addFirst(position);
				}
			}
			positions.addLast(new int[]{0, row});
			row++;
		}

		while (!positions.isEmpty())
		{
			int size = positions.size();
			while (size-- > 0)
			{
				int[] position = positions.removeLast();
				if (position[0] < nums.get(position[1]).size())
				{
					temp.add(nums.get(position[1]).get(position[0]++));
					positions.addFirst(position);
				}
			}
		}

		int[] answer = new int[temp.size()];
		for (int i = 0; i < answer.length; i++)
		{
			answer[i] = temp.get(i);
		}

		return answer;
	}
}
