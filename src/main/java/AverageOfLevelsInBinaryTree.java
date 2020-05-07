import common.LeetCode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 19-Mar-20
 */
@LeetCode(id = 637, name = "Average of Levels in Binary Tree", url = "https://leetcode.com/problems/average-of-levels-in-binary-tree/")
public class AverageOfLevelsInBinaryTree
{
	public List<Double> averageOfLevels(TreeNode root)
	{
		if (root == null)
		{
			return new ArrayList<>();
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		List<Double> values = new LinkedList<>();
		int size;
		TreeNode temp;
		double sum;
		while (!queue.isEmpty())
		{
			size = queue.size();
			sum = 0D;
			for (int i = 0; i < size; i++)
			{
				temp = queue.poll();
				sum += temp.val;

				if (temp.left != null)
				{
					queue.offer(temp.left);
				}

				if (temp.right != null)
				{
					queue.offer(temp.right);
				}
			}
			values.add(sum / size);
		}

		return values;
	}
}
