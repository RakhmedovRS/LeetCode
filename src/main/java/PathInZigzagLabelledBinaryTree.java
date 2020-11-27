import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 11/27/2020
 */
@LeetCode(
	id = 1104,
	name = "Path In Zigzag Labelled Binary Tree",
	url = "https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/",
	difficulty = Difficulty.MEDIUM
)
public class PathInZigzagLabelledBinaryTree
{
	public List<Integer> pathInZigZagTree(int label)
	{
		LinkedList<Integer> answer = new LinkedList<>();
		List<List<Integer>> lists = new ArrayList<>();
		int pow = 0;
		int current = 0;
		boolean fromLeftToRight = true;
		while (current < label)
		{
			List<Integer> list = new ArrayList<>();
			if (fromLeftToRight)
			{
				for (int i = (int) Math.pow(2, pow); i < (int) Math.pow(2, pow + 1); i++)
				{
					list.add(i);
				}
			}
			else
			{

				for (int i = (int) Math.pow(2, pow + 1) - 1; i >= (int) Math.pow(2, pow); i--)
				{
					list.add(i);
				}
			}

			lists.add(list);
			current = (int) Math.pow(2, pow + 1) - 1;
			fromLeftToRight = !fromLeftToRight;
			pow++;
		}

		int i = 0;
		int level = lists.size() - 1;
		List<Integer> list = lists.get(level);
		for (; i < list.size(); i++)
		{
			if (list.get(i) == label)
			{
				break;
			}
		}

		while (level >= 0)
		{
			answer.addFirst(label);
			i /= 2;

			if (level == 0)
			{
				break;
			}

			label = lists.get(--level).get(i);
		}

		return answer;
	}
}
