import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 12/12/2020
 */
@LeetCode(
	id = 1469,
	name = "Find All The Lonely Nodes",
	url = "https://leetcode.com/problems/find-all-the-lonely-nodes/",
	difficulty = Difficulty.EASY,
	premium = true
)
public class FindAllTheLonelyNodes
{
	public List<Integer> getLonelyNodes(TreeNode root)
	{
		List<Integer> answer = new ArrayList<>();
		if (root == null)
		{
			return answer;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		TreeNode current;
		while (!queue.isEmpty())
		{
			current = queue.remove();
			if (current.left == null && current.right != null)
			{
				answer.add(current.right.val);
			}
			else if (current.right == null && current.left != null)
			{
				answer.add(current.left.val);
			}

			if (current.left != null)
			{
				queue.add(current.left);
			}

			if (current.right != null)
			{
				queue.add(current.right);
			}

		}

		return answer;
	}
}
