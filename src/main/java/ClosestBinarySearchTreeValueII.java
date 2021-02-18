import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 2/16/2021
 */
@LeetCode(
	id = 272,
	name = "Closest Binary Search Tree Value II",
	url = "https://leetcode.com/problems/closest-binary-search-tree-value-ii/",
	difficulty = Difficulty.HARD,
	premium = true
)
public class ClosestBinarySearchTreeValueII
{
	public List<Integer> closestKValues(TreeNode root, double target, int k)
	{
		List<TreeNode> list = new ArrayList<>();
		inorder(root, list);
		int left = 0;
		while (left + 1 < list.size() && list.get(left + 1).val < target)
		{
			left++;
		}
		int right = left + 1;

		List<Integer> answer = new ArrayList<>();
		while (answer.size() < k)
		{
			if (left >= 0 && right < list.size())
			{
				if (Math.abs(target - list.get(left).val) <= Math.abs(target - list.get(right).val))
				{
					answer.add(list.get(left--).val);
				}
				else
				{
					answer.add(list.get(right++).val);
				}
			}
			else if (left >= 0)
			{
				answer.add(list.get(left--).val);
			}
			else
			{
				answer.add(list.get(right++).val);
			}
		}
		return answer;
	}

	private void inorder(TreeNode root, List<TreeNode> list)
	{
		if (root == null)
		{
			return;
		}

		inorder(root.left, list);
		list.add(root);
		inorder(root.right, list);
	}
}
