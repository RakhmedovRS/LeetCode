package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 05-Sep-20
 */
@LeetCode(
	id = 1305,
	name = "All Elements in Two Binary Search Trees",
	url = "https://leetcode.com/problems/all-elements-in-two-binary-search-trees/",
	difficulty = Difficulty.MEDIUM
)
public class AllElementInTwoBinarySearchTrees
{
	public List<Integer> getAllElements(TreeNode root1, TreeNode root2)
	{
		List<Integer> first = new ArrayList<>();
		List<Integer> second = new ArrayList<>();
		inorder(root1, first);
		inorder(root2, second);
		List<Integer> result = new ArrayList<>();
		int fPos = 0;
		int sPos = 0;
		while (fPos < first.size() && sPos < second.size())
		{
			if (first.get(fPos) < second.get(sPos))
			{
				result.add(first.get(fPos++));
			}
			else
			{
				result.add(second.get(sPos++));
			}
		}

		while (fPos < first.size())
		{
			result.add(first.get(fPos++));
		}

		while (sPos < second.size())
		{
			result.add(second.get(sPos++));
		}

		return result;
	}

	private void inorder(TreeNode root, List<Integer> values)
	{
		if (root == null)
		{
			return;
		}

		inorder(root.left, values);
		values.add(root.val);
		inorder(root.right, values);
	}
}
