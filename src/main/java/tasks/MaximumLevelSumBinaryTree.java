package tasks;

import common.LeetCode;
import common.TreeNode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 17-Feb-20
 */
@LeetCode(id = 1161, name = "Maximum Level Sum of a Binary Tree", url = "https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/")
public class MaximumLevelSumBinaryTree
{
	public int maxLevelSum(TreeNode root)
	{
		int maxLevel = 0;
		int currentLevel = 1;
		int max = Integer.MIN_VALUE;
		LinkedList<TreeNode> nodes = new LinkedList<>();
		nodes.add(root);

		int levelQuantity;
		int levelSum;
		while (!nodes.isEmpty())
		{
			levelQuantity = nodes.size();
			levelSum = 0;
			while (levelQuantity > 0)
			{
				TreeNode node = nodes.removeFirst();
				if (node != null)
				{
					levelSum += node.val;

					if (node.left != null)
					{
						nodes.addLast(node.left);
					}

					if (node.right != null)
					{
						nodes.addLast(node.right);
					}
				}

				levelQuantity--;
			}

			if (levelSum > max)
			{
				max = levelSum;
				maxLevel = currentLevel;
			}
			currentLevel++;
		}

		return maxLevel;
	}
}
